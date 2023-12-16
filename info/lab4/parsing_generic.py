class Element:
    element = []
    value = ""
    name = ""
    props = []
    is_closing = ""

    def __init__(self, elem: any):
        self.element = str(elem).split(">")
        self.value = self.element[1].strip(" \n")
        self.name = self.element[0].split(" ")[0].strip(" \n")
        self.props = self.element[0].split(" ")[1:]
        i = 0
        while i < len(self.props):
            self.props[i] = self.props[i].strip(" \n")
            if self.props[i] == "":
                self.props.pop(i)
            else:
                i += 1

        self.is_closing = self.element[0].startswith("/")
        if self.is_closing:
            self.name = self.name[1:]


def parse_xml_file_to_json_file(filepath: str, pretty = True):
    with open(filepath, "r", encoding="utf-8") as file:
        new_str = parse_xml_to_json(file.read(), pretty)
        with open(filepath.split(".")[0] + ".json", "w", encoding="utf-8") as output_file:
            output_file.write(new_str)


def parse_xml_to_json(text: str, pretty = True):

    res = ""
    depth = 0
    tab = "    "

    if not pretty:
        tab = ""
    text = text.replace("/>", "></close>")
    elements = []
    for element in text.split("<"):
        element = element.lstrip(" ")
        element = element.rstrip(" ")
        if element.endswith("\n"):
            element = element[:-1]
        elements.append(element)

    elements.pop(0)
    i = 0
    while i < len(elements) - 1:
        i += 1
        #to skip the first element

        if elements[i][0] == "?":
            continue

        element = Element(str(elements[i]))

        if element.name == "root":
            if not element.is_closing:
                res += depth * tab + "{\n"
                depth += 1
        else:
            next_element = Element(elements[i + 1])

            if element.is_closing:
                if next_element.is_closing:
                    depth -= 1
                    if next_element.name == "array":
                        res += "\n" + depth * tab + "]"
                    else:
                        res += "\n" + tab * depth + "}"
                else:
                    res += ",\n"
            else:
                if element.name != "item" and element.name != "array":
                    res += tab * depth + "\"" + element.name + "\": "
                if not next_element.is_closing:
                    if element.name == "array" and len(element.props) == 1:
                        array_name = element.props[0].split("=")[1].strip("\"'")
                        res += depth * tab + "\"" + array_name + "\": \n"
                        res += depth * tab + "["
                    else:
                        if not res.endswith(",\n"):
                            res += "\n"
                        res += tab * depth + "{\n"

                    depth += 1
                else:
                    if len(element.props) != 0 and element.name != "array":
                        res += "\n" + tab * depth + "{\n"
                        depth += 1
                        count = 0
                        if element.value != "":
                            count -= 1
                        for prop in element.props:
                            prop_name = "@" + prop.split("=")[0]
                            prop_value = prop.split("=")[1]

                            res += tab * depth + "\"" + prop_name + "\": " + prop_value
                            count += 1

                            if count < len(element.props):
                                res += ",\n"

                            else:
                                res += "\n"
                        if element.value != "":
                            res += tab * depth + "\"#text\": \"" + element.value + "\"\n"
                        depth -= 1

                        res += tab * depth + "}"
                    else:

                        # if element.value.isnumeric():
                        #     res += element.value
                        # else:
                        res += "\"" + element.value + "\""

    if not pretty:
        res = res.replace("\n", "")
    return res
