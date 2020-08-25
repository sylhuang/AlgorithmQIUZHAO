# 学习笔记

## Sorting Algorithsm
### Bubble Sort
```
class Sort {
    public static void main(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    } 
}
```
### Insertion Sort
```
class Sort {
    public static void main(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) {
                int left = 0;
                int right = j - 1;

                while (left <= right) {
                    int mid = (left + right) / 2;
                    
                    if (arr[mid] == arr[j]) {
                        left = mid;
                        break;
                    } else if (arr[mid] < arr[j]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }

                int tmp = arr[j];

                while (left <= j) {
                    arr[left] = tmp;
                    tmp = arr[left + 1];
                }
            }
        }
    } 
}
```

### Selection Sort
```
class Sort {
    public static void main(int[] arr) {
        int[] copy = arr.clone();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int minIdx = 0;

                if (copy[j] < copy[minIdx]) {
                    minIdx = j;
                }
            }

            arr[i] = copy[minIdx];
            copy[minIdx] = Integer.MAX_VALUE;
        }
    } 
}
```

## dp function for Leetcode 63
f(i, j)是从position 0, 0到position i, j的不同路径数量. 

`f(i, j) = f(i - 1, j) + f(i, j - 1) if pos(i, j) != 1`  
`f(i, j) = 0 if pos(i, j) == 0`
空间可以通过滚动数组优化。