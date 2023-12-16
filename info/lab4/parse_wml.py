def parse_xml_file_to_wml_file(filepath: str):
    with open(filepath, "r", encoding="utf-8") as file:
        new_str = parse_xml_to_wml(file.read())
        with open(filepath.split(".")[0] + ".wml", "w", encoding="utf-8") as output_file:
            output_file.write(new_str)


wml_dtd = """<!DOCTYPE wml PUBLIC "-//WAPFORUM//DTD WML 1.3//EN"
http://www.wapforum.org/DTD/wml13.dtd">"""

def parse_xml_to_wml(text: str):
    text = text.replace("root", "wml")

    text = text[:text.find(">")] + ">\n" + wml_dtd + text[text.find(">") + 1:]
    return text