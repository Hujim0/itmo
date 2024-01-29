import itertools

if __name__ == "__main__":
    perm = list(set(itertools.permutations("12345")))

    perm.sort()

    index = int(input())

    print(perm[index])