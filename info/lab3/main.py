import re

var = 389491
eyes = [":", ";", "X", "8", "=", "["]
noses = ["-", "<", "-{", "<{"]
mouths = ["(", ")", "O", "|", "\\", "/", "P"]



all_smileys = []
for eye in eyes:
    for nose in noses:
        for mouth in mouths:
            all_smileys.append(eye + nose + mouth)

test_strings_first = [
    [
        ";<{\\", 1
    ],
    [
        ";<{\\;<{\\;<{\\;<{\\;<{\\;<{\\", 6
    ],
    [
        "X<(:-O8<\\;-{|=<{P", 0
    ],
    [
        "AjfhjashfjahFSI;<{\\SADasd", 1
    ],
    [
        "".join(all_smileys), 1
    ]
]

test_strings_second = [
    ["а а а э э э а э", "а э а э"],
    ["""Довольно распространённая ошибка
ошибка – это лишний повтор повтор
слова слова. Смешно, не не правда ли?
Не нужно портить хор хоровод.""",
     """Довольно распространённая ошибка
– это лишний повтор
слова. Смешно, не правда ли?
Не нужно портить хоровод."""],
    ["Это это очень жесткий тест😈", "это очень жесткий тест😈"],
    ["У меня закончилась фанта фантазия", "У меня закончилась фантазия"],
    ["Наконец-то то пятый те тест??", "Наконец-то пятый тест??"]]

test_strings_third = [
    ["""Классное слово – обороноспособность, 
которое должно идти после слов: трава 
и молоко.""", ['и', 'идти', 'слов', 'слово', 'трава', 'должно', 'молоко', 'обороноспособность']
     ],
    [
        "Тесты это очень классно и весело!!!! (шутка)",
        ["и"]
    ],
    [
        "Жили были гыли мыли дыли были були лули ааааа???",
        ["Жили", "ааааа"]
    ],
    [
        "Если честно сказать, то мне кажется что после первого теста все должно быть понятно уже",
        ['то', 'все', 'мне', 'быть', 'должно', 'сказать']
    ],
    [
        "или_нет? или нет? илинет? илида? или.нет? ИЛИ НЕТ?",
        ['ИЛИ', 'НЕТ', 'или', 'или', 'нет', 'нет']
    ]
]


def regex_first_task(inp: str):
    count = 0

    regex = re.escape(eyes[var % 6] + noses[var % 4] + mouths[var % 7])

    return len(re.findall(regex, inp))


def regex_second_task(inp: str):
    reg = r"\b(\w+)\s+\1"

    while True:
        matches = re.findall(reg, inp, flags=re.IGNORECASE)
        if (matches == []):
            break
        for match in matches:
            inp = inp.replace(match + " ", "", 1)

    return inp


def regex_third_task(inp: str):
    reg = r"(\b[бвгдзжйклмнпрстфцхшщьъ]*([аеёиуоыэюя])([бвгдзжйклмнпрстфцхшщьъ]*\2*)*\b)"
    res = []
    print(re.findall(reg, inp, flags=re.IGNORECASE))
    for match in re.findall(reg, inp, flags=re.IGNORECASE):
        res.append(match[0])
    res = sorted(res, key=lambda x: (len(x), x))
    return res


def test_task(test: list[str], func):
    if test[1] == func(test[0]):
        print(" - Complete")
    else:
        print(" - Fail")
        print(func(test[0]))


def test_task_full(name: str, tests: list[list[str]], func):
    print(f"----- {name} -----")
    i = 0
    for test in tests:
        i += 1
        print("Test " + str(i), end="")
        test_task(test, func)


test_task_full("Task 1", test_strings_first, regex_first_task)
test_task_full("Task 2", test_strings_second, regex_second_task)
test_task_full("Task 3", test_strings_third, regex_third_task)
