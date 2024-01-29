import math

str_to_int_table = "0123456789ABCDEFGHIJKLMNOPQRSTUVXWYZ"
int_to_fib = [1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657]
int_to_fact = [1, 2, 6, 24, 120, 720, 5040, 40320, 362880]


def change_notation(number: str, prev_notation, new_notation):
    number = number.replace(",", ".")
    dec = str(change_notation_to_decimal(number, prev_notation))

    if new_notation == "fact" or new_notation == "fib":
        if new_notation == "fact":
            notation_abc = int_to_fact
        elif new_notation == "fib":
            notation_abc = int_to_fib
        num = int(dec.split(".")[0])
        res = [0] * max(len(int_to_fib), len(int_to_fact))
        count = 0
        while num != 0 and count < 100:
            for i in range(len(notation_abc) - 1):
                if notation_abc[i + 1] > num:
                    res[i] += 1
                    num -= notation_abc[i]
                    break
            count += 1

        if count == 100:
            print("Слишком большое число!")
            return 0
        res.reverse()

        while res[0] == 0:
            res.pop(0)

        res_str = "".join([str(x) for x in res])
        return res_str

    else:
        whole_part = int(dec.split(".")[0])

        tmp = ""
        notation = int(new_notation)
        while whole_part != 0.0:
            tmp = str(int(whole_part % abs(notation))) + tmp
            whole_part = whole_part // notation

        if (notation < 0):
            tmp = tmp[::-1]

        if dec.count(".") == 0:
            return tmp

        tmp += "."
        frac_part = float(dec) - math.floor(float(dec))

        c = 0
        while c < 5:
            frac_part -= math.floor(frac_part)
            frac_part = (frac_part * notation)

            tmp += str_to_int_table[int(math.floor(frac_part))]
            if frac_part - math.floor(frac_part) == 0.0:
                break

            c += 1

        if tmp[0] == ".":
            tmp = "0" + tmp

        return tmp


def change_notation_to_decimal(num: str, notation):
    if notation != "fact" and notation != "fib":
        if notation == "berg":
            notation = (1 + 5 ** 0.5) / 2 #число фи (золотое сечение)
        else:
            notation = int(notation)

        res = 0
        i = 0
        num = str(num)

        if num.count(".") != 0:
            i = -len(num.split(".")[1])

        for char in num[::-1].replace(".", ""):
            res += str_to_int_table.index(char) * (notation**i)
            i += 1
        return res
    else:
        num = num[::-1]

        res = 0
        for i in range(len(num)):
            if notation == "fact":
                res += int(num[i]) * math.factorial(i + 1)
            elif notation == "fib":
                res += int(num[i]) * int_to_fib[i]
        return res

if __name__ == '__main__':
    print("Выберите число, его систему счисления и новую систему счисления")
    while True:
        print("Новое число:",
              change_notation(input("Ваше число: (пр. 123, 43.05, AA.FF) "),
                              input("Система счисления числа: (пр. 10, 2, fib, fact, berg) "),
                              input("Новая система счисления: (пр. 10, 2, fib, fact) ")))