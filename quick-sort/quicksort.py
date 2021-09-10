def quick_sort(array) :
    quick_sort_impl(array, 0, len(array) - 1)

def quick_sort_impl(array, left, right) :
    if left >= 0 and right >=0 and left < right :
        p = partition(array, left, right)
        quick_sort_impl(array, left, p)
        quick_sort_impl(array, p + 1, right)

def partition(array, left, right) :
    pivot_idx = int((left + right) / 2)
    pivot = array[pivot_idx]
    i = left
    j = right

    while True :
        while array[i] < pivot :
            i = i + 1

        while array[j] > pivot :
            j = j - 1

        if i >= j :
            return j
        
        tmp = array[i]
        array[i] = array[j]
        array[j] = tmp
        i = i + 1
        j = j - 1

array = [2,59,34,89,18,2]
quick_sort(array)
print(array)
