from datetime import datetime
from functools import wraps
from random import randint

class Sorter(object):

    def check_time(f):
        @wraps(f)
        def inner(*args, **kwargs):
            start = datetime.now()
            print("Process '{pc}' started at {st}".format(pc = f.__name__, st = start))
            wrapped = f(*args, **kwargs)
            end = datetime.now()
            delta = (end - start).microseconds
            print("Process '{pc}' ended at {et}".format(pc = f.__name__, et = end))
            print("Duration: {du}ms".format(du = str(delta / 1000)))
            return wrapped
        return inner

    def shuffle(self, input):
        for i in range(0, len(input)):
            rn = randint(0, len(input) - 1)
            temp = input[rn]
            input[rn] = input[i]
            input[i] = temp
        return input

    def check_res(self, res):
        for i in range(0, len(res) - 1):
            if res[i + 1] < res[i]:
                return False
        return True

    @check_time
    def sort(self, input, type):
        options = { 'merge': self.__merge_sort,
                    'bubble': self.__bubble_sort }
        return options[type](input)

    def __merge_sort(self, input):
        if len(input) > 1:
            pivot = (len(input)) // 2
            left = self.__merge_sort(input[:pivot])
            right = self.__merge_sort(input[pivot:])
        else:
            return input

        return self.__merge(left, right)

    def __merge(self, left, right):
        i = 0
        j = 0
        res = []
        while (i < len(left) and j < len(right)):
            if left[i] < right[j]:
                res.append(left[i])
                i += 1
            else:
                res.append(right[j])
                j += 1
        if (i < len(left) and j == len(right)):
            return res + left[i:]
        elif (i == len(left) and j < len(right)):
            return res + right[j:]
        else:
            return res

    def __bubble_sort(self, input):
        changed = True
        while changed == True:
            changed = False
            for i in range(0, len(input) - 1):
                if input[i] > input[i + 1]:
                    changed = True
                    temp = input[i + 1]
                    input[i + 1] = input[i]
                    input[i] = temp
        return input

if __name__ == "__main__":
    sorter = Sorter()
    tp = 'merge'
    test01_in = [0, 0, 0, 0]
    test01_res = sorter.sort(test01_in, tp)
    print(test01_res)

    test02_in = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    test02_res = sorter.sort(test02_in, tp)
    print(test02_res)

    test03_in = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
    test03_res = sorter.sort(test03_in, tp)
    print(test03_res)

    test04_in = sorter.shuffle([x for x in range(0, 5000)])
    print(sorter.check_res(test04_in))
    test04_res = sorter.sort(test04_in, tp)
    print(sorter.check_res(test04_res))
