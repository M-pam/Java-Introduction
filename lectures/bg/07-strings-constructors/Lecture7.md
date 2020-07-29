# Lecture 7
#java course#

## Strings & Constructors & OOP Exercises

### Какво е `String`?

`String` е **class**, който репрезентира текст. За разлика от другите типове данни, 
които изучавахме, той не е примитивен, а е съставен от примитивни типове.

`String` се характеризира с това че има `n` на брой символи `char`. Или с други думи
масив от символи `char[n]`.

В Java можем да различим `char` от `String`, поглеждайки броя на кавичките.  
`char` се създава с единични кавички `char a ='A';`, а `String` с двойни кавички
`String a = "A";`

> типът `char` репрезентира само 1 символ

#### Дължина на `String`

Дължината може да бъде достъпена чрез методът `length()`.

- Пример

    ```java
    String foo = "foo";
    
    System.out.println(foo.length()); // принтира 3
    ```

    > Начина по който достъпваме дължината на текста се различава от начина,
     по който достъпваме дължината на масив. В първия случай използваме **method** `length()`,
     а във втория **property** `length`.


#### Събиране на `String`

Един `String` може да бъде събиран с друг `String`, като резултата е трети `String` 

- Пример

    ```java
    String firstName = "John";
    String lastName = "Doe";
    
    String name = firstName + lastName;
    
    System.out.println(name); // Принтира John Doe
  
    int age = 30;
    String nameAndNumber = name + age;
  
    System.out.println(nameAndNumber); // Принтира John Doe30
    ```
    
    > Текстът може да бъде само събиран с други типове данни и не може да бъде изваждан, умножаван и тнт...

#### Има разлика м/у символ (`char`), масив от символи (`char[]`) и текст (`String`)

Общото м/у трите типа е символът `char`, но те се различават с това,
че всеки следващ тип надгражда над предходния.

```java
char char1 = 'J';
char char2 = 'o';
char char3 = 'h';
char char4 = 'n';

char[] chars = {'J', 'o', 'h', 'n'}

String myString = "John";
```

> `String` е изграден от `char[]`, който е изграден от множество `char`.

#### Създаване на `String`

`String` се създава с двойни кавички.

```java
String firstString = "John";

String secondString = new String("John");
```
> Втория начин за създаване на `String` не е за предпочитане.


#### Как да проверяваме за еднаквост (equality)?

`String` е сложен тип или също така референтен тип.
Това означава, че ако използваме оператор за сравнение `==`, 
ние ще сравним адреси в паметта. За да сравним текста,
който е репрезентиран от конкретния `String`, може да 
ползваме **method** `equals()`

- Пример

    ```java
    String firstString = "John";
    
    String secondString = new String("John");
    
    String firstPart = "Jo";
    String secondPart = "hn";
    
    String thirdString = firstPart + secondPart;
    
    System.out.println(firstString == secondString);   // false
    System.out.println(firstString == thirdString);    // false
    
    System.out.println(firstString.equals(secondString));  // true
    System.out.println(firstString.equals(thirdString));   // true
    ```
    > Методът `equals` има 1 аргумент (параметър).

ℹ️ За повече информация относно това, как може да обработваме един **String** вижте 
това [youtube видео](https://www.youtube.com/watch?v=AMy6Io917b4) 
и това [youtube видео](https://www.youtube.com/watch?v=ylIwjw1_xpY).

### Конструктори (constructors)

Досега учихме как да моделираме един обект създавайки **class**, с който описваме неговото 
**поведение (methods)** и **характеристики (properties)**.  
Знаем че използвайки вече моделираният **class**, ние можем да **създаваме (инстанцираме)**
нови обекти. 

Това инстанциране става посредством **конструктор (constructor)**. Конструкторът е средството, с което
ние можем да заделим място в паметта и да създадем нова променлива от сложен (референтен) тип. 🏗️

Всеки **class** има поне един **конструктор**. Извикването на конструктора става чрез ключовата дума `new` 
последвана от името на класът и кръгли скоби `new <ClassName>()`.

- Пример

    ```java
    Car myCar = new Car();
    ```

    > В този пример **създаваме (инстанцираме)** нова променлива с име `myCar`.
    За да осъществим това инстанциране ние използваме **конструкторът (constructor)** на класът `Car`
    (това е дясната част на уравнението) и ключовата дума `new`. 🔑


#### Какво приложение намират конструкторите?

Конструкторът е първото нещо което трябва да бъде изпълнено от програмата 
преди да бъде създаден обект от даден тип. Това го прави подходящо място за подаване на параметри на обекта.
Тези параметри могат да служат, като начални стойности на обекта.

**Пример**

Ако искаме да моделираме обекта кола (car), така че една кола да не може
да бъде създадена без да има модел, можем да използваме конструктор с параметър
моделът на колата за да постигнем това.

Ето как би изглеждало това в Java

- Car.java
   
    ```java
    class Car {
        
        String model;
        
        Car(String newModel) { // конструкторът на класът Car с един параметър
            model = newModel; // подадения параметър на конструктора бива записан в свойстово model на класът
        }
    }
    ```

- Main.java
    
    ```java
    class Main {
    
        public static void main(String[] args){
            
            Car volvo = new Car("Volvo"); // инстанцираме нова кола с модел Volvo
            Car nissan = new Car("Nissan"); // инстанцираме нова кола с модел Nissan
        }
    }
    ```
    > В момента не можем да инстанцираме нова кола безда подадем модел.  
    Следния синтаксис не би компилирал `new Car()`, тъй като липсва параметър в конструктора. 


#### Какво друго трябва да знаем за конструкторите?

###### Всеки class има поне един конструктор.

###### Конструктор по подразбиране (Default constructor)

Ако ние създадем **class** без конструктор, то Java приема че има
един конструктор без параметри.

- Пример

    ```java
    class Person {

    }
    ```

    ```java
    Person pesho = new Person(); // използваме default constructor
    ```

###### Един class може да има повече от един конструктор

Всеки **class** може да дефинира n на брой конструктори с различен на брой параметри.
Не може да има два конструктора с еднакъв тип и еднакъв брой параметри.

- Пример

    ```java
    class Person {
       String name;
       int age;
    
        Person() { // конструктор без параметри  
        }
      
        Person(String personName) { // конструктор с един String параметър
            name = personName;
        }     
      
        Person(int personAge) { // конструктор с един int параметър
            age = personAge;
        }
      
        Person(String personName, int personAge) { // конструктор с един int и един String параметър
            name = personName;
            age = personAge;
        }
    }
    ```

    ```java
    Person emptyPerson = new Person();
    
    Person personWithName = new Person("Ivan");
  
    Person personWithAge = new Person(30);
  
    Person personWithNameAndAge = new Person("Ivan", 30);
    ```

###### Къде да разположим конструктора в кода?
Добре написания код следва масово установените практики за писане на код.
Една такава практика е конструкторите да се пишат под свойставата на класа и над методите му.

---

### Exercises

#### Task 1

Моделирайте животното хамелион. Един хамелион се характеризира с
- цвят (color)
- тегло (weight)
- способността да сменя цветът си (change color)

Хамелионът може да приема всякакъв цвят освен сив (gray)

> Смяната на цвят ще е **method**, който има 1 параметър, новият цвят 🦎

<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

```java
public class Chameleon {
    String color;
    double weight;

    /**
     * Change the color of the chameleon. If the desired color is gray then the color won't be changed.
     *
     * @param color the new color of the chameleon.
     */
    void changeColor(String color) {
        if ("gray".equals(color)) {
            return;
        }

        this.color = color;
    }

}
```

</p>
</details>

#### Task 2

Моделирайте човек. Един човек се характеризира с
- име (name)
- години (age)
- пол (is woman)

Човекът може да има следното поведение
- да яде (eat) - изписва се `Eating...` на конзолата
- да ръсте (grow up) - увеличават се текущите му години с 1
- да пие вода (drink water) - на човека може да му се каже колко вода да пие
    - ако е над 1 литър се изписва че водата е прекалено много `This is too much water!`
    - ако е под или равно на 1 литър се изписва името на човека и количеството вода което пие
      `Ivan is drinking 0.5 liters of watter`
- човекът може да пресмята на каква възраст ще е след определен брой години (calculate age)
    - пресмятането на годините не трябва да променя текущите му години
    - резултата от пресмятането трябва да бъде върнат като резултат, а не да се принтира

> Изчисляването на годините ще представлява **method**, който ще има същия **return type**, като
типът на полето години. Методът ще изчислява и ще връща получените години. 🤸

<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

```java
public class Person {
    String name;
    int age;
    boolean isWoman;

    void eat() {
        System.out.println("Eating...");
    }

    void growUp() {
        age++;
    }

    void drinkWater(double liters) {
        if (liters > 1) {
            System.out.println("This is too much water!");
        } else {
            System.out.printf("%s is drinking %.2f liters of watter", name, liters);
        }
    }

    int calculateAge(int years) {
        return age + years;
    }
}
```

</p>
</details>

#### Таск 3

Напишете програма, която намира най-дългата дума в даден текст.

- Текстът се въвежда от потребителя
- Най дългата дума бива изписана на екрана заедно с нейната дължина

> Класът `String` има метод `split()` (раздели), който приема като аргумент
нещото, по което ще бъде разделен текстът. Резултатът от този метод е `String[]`

<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

```java
public class Task3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] words = input.split("\\s"); // раздели текста на space-ове

        String longestWord = findLongest(words);

        System.out.printf("length: %d word: %s", longestWord.length(), longestWord);
    }

    private static String findLongest(String[] words) {
        String longestWord = null;
        int maxLength = 0;

        for (String word : words) {
            if (word.length() > maxLength) {
                longestWord = word;
                maxLength = word.length();
            }
        }

        return longestWord;
    }
}
```

</p>
</details>

#### Task 4

Напишете програма, която може да немира най-тежката дума измежду множество думи.
Това колко е тежка една дума се определя от сумата на символите на думата. Всеки
символ има различна тежест. Възможните символи са от `a` до `z`, където `a`
има тежест **1**, а `z` тежест **26**.
Главните и малки символи имат еднаква тежест, например `a` и `A` имат тежест **1**.

**Пример:**  
Въведете думи: `alpha beta gama`  
Думата `alpha` има най-голяма тежест 38  

**Обяснение:**  
`alpha` има тежест `1 + 12 + 16 + 8 + 1 = 38`  
`beta` има тежест `2 + 5 + 20 + 1 = 28`  
`gama` има тежест `7 + 1 + 13 + 1 = 22`  

<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

```java
import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] words = input.split("\\s");

        int maxWeight = 0;
        String heaviestWord = null;

        for (String word : words) {
            int weight = computeWeight(word);

            if (weight > maxWeight) {
                maxWeight = weight;
                heaviestWord = word;
            }
        }

        System.out.printf("weight: %d word: %s", maxWeight, heaviestWord);
    }

    static int computeWeight(String word) {
        int weight = 0;

        for (int i = 0; i < word.length(); i++) {
            char symbol = word.charAt(i);
            weight += computeWeight(symbol);
        }

        return weight;
    }

    static int computeWeight(char letter) {
        // 'A' is 10 and 'Z' is 35 that's why I subtract 9 so that I can fit between 1 and 26
        return Character.getNumericValue(letter) - 9;
    }
}
```

</p>
</details>

#### Task 5

Напишете програма, която проверява дали даден списък от числа е подреден.
Един списък е подреден, когато следващото число **НЕ** е по-малко от предишното.

- Пример за подреден спиък: `-8,3,4,5,5,10`

- Пример за неподреден списък: `-8,-10,3,4`

Програмата, първо трябва да изисква число `n`, представляващо броя редове, които ще се въведат.
След това програмата, изисква редовете с числа. Един ред представлява числа разделени със запетая.

Програмата, като краен резултат трябва да изпише `n` на брой пъти `true` или `false`, съответно
за сортиран или несортиран списък.

- Пример

```
Въведете брой редове: 2
Въведете списък с числа:
1,2,3,3,4
Въведете списък с числа:
8,9,4,10

true
false
```

<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

```java
Scanner userInput = new Scanner(System.in);

System.out.print("Въведете брой редове: ");
int n = userInput.nextInt();

boolean[] sortedLists = new boolean[n];

for (int i = 0; i < n; i++) {
    System.out.println("Въведете списък с числа:");

    String input = userInput.next();
    String[] firstList = input.split(",");

    if (firstList.length == 0 || firstList.length == 1) {
        sortedLists[i] = true;
        continue;
    }

    for (int j = 1; j < firstList.length; j++) {
        int previous = Integer.parseInt(firstList[j - 1]);
        int current = Integer.parseInt(firstList[j]);

        if (previous <= current) {
            sortedLists[i] = true;
        } else {
            sortedLists[i] = false;
            break;
        }
    }
}

for (boolean isSorted : sortedLists) {
    System.out.println(isSorted);
}
```

</p>
</details>