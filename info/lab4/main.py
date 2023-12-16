#XML to JSON, thursday
import time

import xmltodict
import json

import parse_wml
import parsing_generic
import parsing_regex

def library_parsing(text: str):
    doc = xmltodict.parse(text)
    return json.dumps(doc, ensure_ascii=False, indent=4).encode("utf-8").decode()

def measure_time(test_name, function, text):
    st = time.time()
    for i in range(100):
        function(text)
    elapsed_time = time.time() - st

    print(f"- {test_name}: " + "%.5f" % elapsed_time)
    time.sleep(1)

if __name__ == "__main__":
    var = 91 % 36

    parsing_generic.parse_xml_file_to_json_file("thursday.xml", True)

    with open("thursday.xml", "rb") as fd:
        doc = xmltodict.parse(fd.read())
        with open("thursday_dict_to_json.json", "w", encoding="utf-8") as output:
            output.write(json.dumps(doc, ensure_ascii=False, indent=4).encode("utf-8").decode())

    parsing_regex.parse_xml_file_to_json_file("thursday.xml")
    parse_wml.parse_xml_file_to_wml_file("thursday.xml")

    #time measure

    test_input = open("thursday.xml", "r", encoding="utf-8").read()

    measure_time("My generic parser", parsing_generic.parse_xml_to_json, test_input)
    measure_time("My regex parser", parsing_regex.parse_xml_to_json, test_input)
    measure_time("Library parser", library_parsing, test_input)

