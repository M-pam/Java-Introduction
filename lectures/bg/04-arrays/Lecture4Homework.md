# Homework Lecture 4
#java course#

## Arrays 

### Task 1

```text
Да се прочете масив от екрана и да се намери най-малкото число кратно на 3 от масива 
(за улеснение, нека първият елемент на масива, въведен от потребителя да е винаги число кратно на 3).

Може да се опитате и без първото да е кратно на 3.
```

<details><summary><b>Solution</b> 👀</summary> 
<p>

###### Solution 1

```java
Scanner scanner = new Scanner(System.in);

System.out.print("Enter size of the array: ");
int size = scanner.nextInt();

int[] myArray = new int[size];

System.out.println("First number should be multiple of 3!");
for (int i = 0; i < myArray.length; i++) {
    System.out.print("array[" + i + "] = ");
    myArray[i] = scanner.nextInt();
}

int min = myArray[0];

for (int i = 1; i < myArray.length; i++) {

    int currentElement = myArray[i];

    if (currentElement % 3 == 0 && currentElement < min) {
        min = currentElement;
    }
}

System.out.println("The smallest element multiple of 3 is: " + min);
```  

###### solution 2

```java
Scanner scanner = new Scanner(System.in);

System.out.print("Enter size of the array: ");
int size = scanner.nextInt();

int[] myArray = new int[size];

for (int i = 0; i < myArray.length; i++) {
    System.out.print("array[" + i + "] = ");
    myArray[i] = scanner.nextInt();
}

int min = 0;
boolean minIsInitialized = false;

for (int i = 0; i < myArray.length; i++) {

    int currentElement = myArray[i];

    if (currentElement % 3 != 0) {
        continue;
    }

    if (!minIsInitialized) {
        min = currentElement;
        minIsInitialized = true;
    } else if (min > currentElement) {
        min = currentElement;
    }
}

if (minIsInitialized) {
    System.out.println("The smallest element multiple of 3 is: " + min);
} else {
    System.out.println("None of the numbers are multiple of 3!");
}
```

</p>
</details>

### Task 2

```text
Да се подкани потребителя да въведе размер на масива кратен на 2.
След това да се подкани потребителя с подходящи съобщения да въведе половината от елементите.
На останалите елементи на масива да се зададат стойности като на предишните 2.
Накрая да се изведе масива на екрана.

Пример:
Въведете размер за масива: 8
Въведете 1-я елемент:
10
Въведете 2-я елемент:
12
Въведете 3-я елемент:
1
Въведете 4-я елемент:
-4

Резултат:
10 12 1 -4 10 12 1 -4
```

<details><summary><b>Solution</b> 👀</summary> 
<p>

```java
Scanner scanner = new Scanner(System.in);

System.out.print("Enter size of the array multiple of 2: ");
int size = scanner.nextInt();

int[] array = new int[size];

int half = array.length / 2;

System.out.println("Enter " + half + " items\n");
for (int i = 0; i < half; i++) {
    System.out.print("array[" + i + "] = ");
    int value = scanner.nextInt();

    array[i] = value;
    array[half + i] = value;
}

System.out.println("Here is the array: ");

for (int i = 0; i < array.length; i++) {
    System.out.print(array[i] + ", ");
}
```  

</p>
</details>

### Task 3

```text
Да се въведе число от конзолата, след което да се създаде масив с 10 елемента по следния начин:
Първите 2 елемента на масива са въведеното число.
Всеки следващ елемент на масива е равен на сбора от предишните 2 елемента в масива.
(Задачата за Фибоначи но с числа запазени в масива и започващи от число, избрано от потребителя)
След това изведете масива на конзолата.

Пример 1:
Въведете число: 1
1 1 2 3 5 8 13 21 34 55

Пример 2:
Въведете число: 3
3 3 6 9 15 24 39 63 102 167 🐚
```

> Няколко интересни факта за Фибоначи:  
[The magic of Fibonacci numbers](https://www.youtube.com/watch?v=SjSHVDfXHQ4&fbclid=IwAR16DatoUczikQgzwQHtpBcIQe5DhGEcXWsXv0CGMZ6yjx4QMZL1y0yVOdw)  
[Nature by Numbers](https://www.youtube.com/watch?v=kkGeOWYOFoA&fbclid=IwAR1ClvHqnuBsG04hz7RgUZwG9D3j_mSYXCqSUuYAze1SylakjW0GMFOK5qI)  
[Константно намиране на n-тото число от поредицата на Фибоначи](http://www.maths.surrey.ac.uk/hosted-sites/R.Knott/Fibonacci/fibFormula.html)

### Task 4

```text
Създайте масив с големина зададена от потребителя.
Въведете стойностите на масива от конзолата.
Да се провери дали въведения масив е огледален.

Следните масиви са огледални:
[3 7 7 3]
[4]
[1 55 1]
[6 27 -1 5 7 7 5 -1 27 6]

Пример:
Въведете размер за масива: 5
Въведете 1-я елемент: 10
Въведете 2-я елемент: 66
Въведете 3-я елемент: 1
Въведете 4-я елемент: 66
Въведете 5-я елемент: 10

Масивът е огледален
```

### Task 5

```text
Напишете програма, която създава масив с 10 елемента от
тип double и инициализира всеки от елементите със стойност
равна на индекса на елемента умножен по 3 и разделен на сумата от индексите на масива.
Да се изведат елементите на екрана закръглени до втори знак след десетичната запетая.
```

### Task 6

```text
Напишете програма, която първо чете масив от клавиатурата и после
създава нов масив със същия размер по следния начин: 
стойността на всеки елемент от втория масив да е равна на сбора от 
предходния и следващият елемент на съответния елемент от първия масив.
Да се изведе получения масив.

Пример:
Въведете размер на масива: 4
Въведете елементите на масива:
2
3
-11
7
Полученият масив е: {3, -9, 10, -11}
```

> **Обяснение:**  
В полученият масив числото на индекс `0` `(3)` е получено, 
като се сумират елементът с индекс `1` и елементът с индекс `-1`. 
Тъй като елемент на `-1` индекс няма `(ArrayIndexOutOfBounds)`, събираме с `0` `(0 + 3 = 3)`.  
Числото на индекс `1` `(-9)` е получено, като се сумират числата с 
индекси `0` и `2` от входния масив `(2 + -11 = 9)`.  
Числото на индекс `2` `(10)` е получено, като се съберат числата с индекси `1` и `3` 
от входния масив `(3 + 7 = 10)`.  
За числото на индекс `3` `(-11)` (последното), 
логиката е аналогична на тази при първото число. Тъй като няма елемент на индекс `4`, 
то е равно на числото с индекс `2` от входния масив `(-11 + 0 = -11)`.

### Task 7

```text
Напишете програма, която намира и извежда най-дългата редица от еднакви поредни елементи в даден масив.
Пример:
Въведете размер на масива: 10
Въведете елементите на масива:
2
1
1
2
3
3
2
2
2
1

Максималната редица е: 2 2 2
```

### Task 8

```text
Напишете програма, която първо чете 2 масива от конзолата (от целочислен тип)
и после извежда съобщение дали са еднакви и дали са с еднакъв размер.

Пример:
Въведете размер за първия масив: 3
Въведете елементите на първия масив:
13
2
7

Въведете размер за втория масив: 3
Въведете елементите на втория масив:
13
5
7

Масивите са различни.
Масивите имат еднакъв размер.
```
