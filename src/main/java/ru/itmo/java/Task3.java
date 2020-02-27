package ru.itmo.java;

import java.util.Map;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return new int[0];
        }
        int[] result = new int[inputArray.length];
        for (int i = 1; i < inputArray.length; ++i) {
            result[i] = inputArray[i - 1];
        }
        result[0] = inputArray[inputArray.length - 1];
        return result;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Если входной массив пуст или равен null - вернуть 0
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null) {
            return 0;
        }
        if (inputArray.length == 1) {
            return inputArray[0];
        }
        int maxind1 = 0;
        int maxind2 = 1;
        for (int i = 0; i < inputArray.length; ++i) {
            if (inputArray[maxind1] < inputArray[i]) {
                i = maxind1;
            }
        }
        if (maxind1 == maxind2) {
            maxind2 = 0;
        }
        for (int i = 0; i < inputArray.length; ++i) {
            if (inputArray[maxind2] < inputArray[i] && i != maxind1) {
                i = maxind2;
            }
        }
        return inputArray[maxind1] * inputArray[maxind2];
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        String lowedStr = input.toLowerCase();
        int foundedSymbols = 0;
        for (int i = 0; i < lowedStr.length(); ++i) {
            if (lowedStr.charAt(i) == 'a' || lowedStr.charAt(i) == 'b') {
                ++foundedSymbols;
            }
        }
        return (int)(foundedSymbols / (double)lowedStr.length() * 100);
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        for (int i = 0; i < input.length() / 2; ++i) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null || input == "") {
            return "";
        }
        StringBuilder result = new StringBuilder();
        char currentSymbol = input.charAt(0);
        int charCount = 0;
        for (int i = 0; i < input.length(); ++i) {
            if (input.charAt(i) == currentSymbol) {
                ++charCount;
            } else {
                result.append(currentSymbol);
                result.append(charCount);
            }
        }
        result.append(currentSymbol);
        result.append(charCount);
        return result.toString();
    }

    String sortedStr(String str) {
        StringBuilder b = new StringBuilder(str);
        for (int i = 0; i < str.length(); ++i) {
            for (int j = i + 1; j < str.length(); ++j) {
                if (b.charAt(i) > b.charAt(j)) {
                    char x = b.charAt(i);
                    char y = b.charAt(j);
                    b.setCharAt(i, y);
                    b.setCharAt(j, x);
                }
            }
        }
        return b.toString();
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || two == null) {
            return false;
        }
        String a = sortedStr(one);
        String b = sortedStr(two);
        return a.equals(two);
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        String sorted = sortedStr(s);
        for (int i = 1; i < s.length(); ++i) {
            if (sorted.charAt(i - 1) == sorted.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null) {
            return new int[0][0];
        }
        int le = m.length;
        int[][] result = new int[le][le];
        for (int x = 0; x < le; ++x) {
            for (int y = 0; y < le; ++y) {
                result[y][x] = m[x][y];
            }
        }
        return result;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if (inputStrings == null) {
            return "";
        }
        char sep = ' ';
        if (separator != null) {
            sep = separator.charValue();
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < inputStrings.length; ++i) {
            result.append(inputStrings[i]);
            if (i != inputStrings.length - 1) {
                result.append(sep);
            }
        }
        return result.toString();
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (inputStrings == null || prefix == null) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < inputStrings.length; ++i) {
            if (inputStrings[i] == null) {
                continue;
            }
            if (inputStrings[i].substring(0, prefix.length()) == prefix) {
                ++result;
            }
        }
        return result;
    }
}
