import math

test = "010101110001110"  # нет ошибок
test2 = "010101111001110"  # ошибка в 8-ом номере (9 знаке)

def check_for_errors(msg: str):
    all_xors_res = 0

    # добавили не достающий первый ноль
    msg = "0" + msg

    for j in range(len(msg)):
        if msg[j] == "1":
            all_xors_res = all_xors_res ^ j

    return all_xors_res


def return_all_info_bits(msg: str):
    res = ""

    for i in range(2, len(msg)):
        if (i + 1) in {2, 4, 8, 16, 32, 64, 128}:
            continue
        res += msg[i]

    print(msg)
    print("Только информационные биты: \n" + res)


while True:
    choice = int(input("Выберите режим проверка кода или добавление бит четности (0/1):"))

    if choice == 1:
        message = input("Напишите сообщение без бит четности: ")

        is_bin = True
        for char in message:
            if char != "0" and char != "1":
                is_bin = False

        if not is_bin:
            message = bin(int(message))[2:]

        parity_bit_count = math.floor(math.log2(len(message))) + 2

        print("Минимальное количество бит четности: " + str(parity_bit_count))

        for i in range(0, parity_bit_count):
            message = message[:2 ** i] + "*" + message[2 ** i:]

        all_xors = bin(check_for_errors(message))[2:]
        while len(all_xors) != parity_bit_count:
            all_xors = "0" + all_xors

        for digit in all_xors[::-1]:
            message = message.replace("*", digit, 1)

        print("Новое сообщение с битами четности: \n" + message)
    else:

        message = input("Напишите полное сообщение: ")
        # message = bin(int(input("Напишите полное сообщение: ")))[2:]
        is_bin = True
        for char in message:
            if char != "0" and char != "1":
                is_bin = False

        if not is_bin:
            message = bin(int(message))[2:]
        """
        Плюс один к len(message), потому что в оригинальном сообщении мы не пишем нулевой бит
        Контрольные биты будут располагаться по степеням двойки с добавленным 0: 0,1,2,4,8....
        Плюс один в конце, потому что мы учитываем нулевой бит, как контрольный
        """

        parity_bit_count = math.ceil(math.log2(len(message) + 1))

        """
        Запишем адреса 16 символьного сообщения в двоичном виде:
        |---------------------------|
        | 0000 | 0001 | 0010 | 0011 | теперь первый разряд обозначает все биты, которые будут  
        |---------------------------| проверяться первым четным битом в позиции 0001
        | 0100 | 0101 | 0110 | 0111 |
        |---------------------------| все последующие четные биты, лежащие в 0010, 0100, 1000 
        | 1000 | 1001 | 1010 | 1011 | будут маской для чисел которые мы берем.
        |---------------------------| т.е. четный бит рассматривает те адреса, в которых 
        | 1100 | 1101 | 1110 | 1111 | побитовое "и" будет равнятся четному биту.
        |---------------------------|

        Чтобы проверить сообщение возьмем побитовое xor всех едениц в сообщении
        """

        all_xors = check_for_errors(message)
        print(parity_bit_count)

        # минус один потому что мы рассматриваем сообщение без первого бита
        all_xors -= 1

        if all_xors == -1:
            print("Ошибок нет! :)\nВот исходное сообщение:\n" + message)

            return_all_info_bits(message)

            continue

        print("Ошибка на " + str(all_xors + 1) + " знаке: ")
        print(message)
        print(" " * all_xors + "^")

        message = message[:all_xors] + str((int(message[all_xors]) + 1) % 2) + message[all_xors + 1:]

        if check_for_errors(message) == 0:
            print("Исправленное сообщение:\n" + message)

            return_all_info_bits(message)

