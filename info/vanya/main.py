import re

var = 408614

eyes = ":;X8=["
noses = ["-", "<", "-{", "<{"]
mouths = "()O|/\\P"

my_smiley = eyes[var % 6] + noses[var % 4] + mouths[var % 7]

def test_first_task():
    test_strings = [
        "8<{P",
        ";<)",
        "X-{|X-{|"
        "тест смайлика",
        ""
    ]

    for test in test_strings:
        print(len(re.findall(re.escape("X-{|"), test)))

test_first_task()

def test_second_task():
    test_strings = [
        "17:00",
        "17:59",
        "23:59",
        "24:43",
        "23:50:43",
        "4343:3414:231 привет 23:43:43",
        "65:32:12"
    ]

    for test in test_strings:
        matches = re.findall(r"\b(([0-1][0-9]|2[0-3])(:[0-5][0-9])+)\b", test)

        for match in matches:
            test = test.replace(match[0], "(TBD)")

        print(test)

----

#дописать функцию, туда сюда
        re.findall(r"\w*К[^кра]Р[^кра]А\w*", str, flags=re.IGNORECASE)

test_second_task()

