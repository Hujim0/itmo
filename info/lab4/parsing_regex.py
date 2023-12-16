import re


def parse_xml_file_to_json_file(filepath: str):
    with open(filepath, "r", encoding="utf-8") as file:
        new_str = parse_xml_to_json(file.read())
        with open(filepath.split(".")[0] + "_regex.json", "w", encoding="utf-8") as output_file:
            output_file.write(new_str)


def parse_xml_to_json(text: str):

#add quotes values
    match = re.search(r"(?<=>)[^\n^\"]+(?=</)", text)
    while match != None:
        text = text[:match.span()[0]] + "\"" + match.group() + "\"" + text[match.span()[1]:]
        match = re.search(r"(?<=>)[^\n^\"]+(?=</)", text)

#add commas
    match = re.search(r"</\w+>(?!\n\s*</\w+)(?!,)", text)
    while match != None:
        text = text[:match.span()[0]] + match.group() + "," + text[match.span()[1]:]
        match = re.search(r"</\w+>(?!\n\s*</\w+)(?!,)", text)


#replace all item elements that don't need a comma
    match = re.search(r"</item>(?![\n\s]*<item>)", text)
    while match != None:
        text = text[:match.span()[0]] + "}" + text[match.span()[1]:]
        match = re.search(r"</item>(?![\n\s]*<item>)", text)

#make new brackets
    text = text.replace("</array>", "]")
    text = text.replace("<item>", "{")

#replacing opening tags
    match = re.search(r"<\w+>(?=\")", text)
    while match != None:
        text = text[:match.span()[0]] + "\"" + match.group().strip("<>") + "\": " + text[match.span()[1]:]
        match = re.search(r"<\w+>(?=\")", text)

#replace the array declaration
    match = re.search(r"<array [\w\s]*name=([^>]+)>", text)
    while match != None:
        text = text[:match.span()[0]] + match.group(1) + ": [" + text[match.span()[1]:]
        match = re.search(r"<array [\w\s]*name=([^>]+)>", text)

# #
    match = re.search(r"<\w+>(?=\s+<\w+)", text)
    while match != None:
        text = text[:match.span()[0]] + "\"" + match.group(0).strip("<>") + "\": {" + text[match.span()[1]:]
        match = re.search(r"<array [\w\s]*name=([^>]+)>", text)

    #complex objects
    match = re.search(r"<(?=\w+[ \s]\w+=)[^>]+>([^<]+)", text)
    while match != None:
        in_element = match.group(0).strip("<").split(">")[0]

        element = f"\"{in_element.split(' ')[0]}\": " + "{ "

        attributes_str = ""

        for attribute in in_element.split(" ")[1:]:
            attribute_name = attribute.split("=")[0].strip(" \n")
            attribute_value = attribute.split("=")[1].strip(" \n")
            attributes_str += f"\"@{attribute_name}\": {attribute_value}, "

        text_attribute = match.group(0).split(">")[1]
        if text_attribute != "":
            attributes_str += f"\"#text\": {text_attribute} "
        else:
            attributes_str = attributes_str[:-2] + " "
        attributes_str += "}"

        text = text[:match.span()[0]] + element + attributes_str + text[match.span()[1]:]
        match = re.search(r"<(?=\w+ \w+=)[^>]+>([^<]+)", text)

#add missing closing brackets
    match = re.search(r"</\w+>\s+(</\w+>)", text)
    while match != None:
        text = text[:match.span()[0]] + match.group(0).replace(match.group(1), "}") + text[match.span()[1]:]
        match = re.search(r"</\w+>\s+(</\w+>)", text)

#replace the roots
    text = text.replace("<root>", "{")

    match = re.search(r"</root>.", text)
    text = text.replace(match.group(0), "}")

#delete the xml header
    match = re.search(r"<\?[^>]+>", text)
    text =text.replace(match.group(0), "")

#delete closing tags
    match = re.search(r"</\w+>", text)
    while match != None:
        text = text[:match.span()[0]] + text[match.span()[1]:]
        match = re.search(r"</\w+>", text)

    return text
