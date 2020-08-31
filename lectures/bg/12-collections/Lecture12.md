# Lecture 12
#java course#

## Collections

### Структури от данни (Data structures)

Често при писането на програми се налага някаква информация да бъде запаметявана от програмата.

Например ако пишем програма, която представлява онлайн система за конни надбягвания, която пази информация като:
- На кои дати в кои градове има конни надбягвания.
- Във всяко надбягване кои са участниците.
- Кой участник колко конни надбягвания е спечелил и тнт.

Запаметяването на такъв тип данни може да бъде извършено под множество форми или така наречените структури от данни.  

Всяка структура от данни има своите специфики, предимства и недостатъци. Избора каква струтктура от данни
ще използваме би зависил от операциите, които ще се налага да се извършват в/у тези данни.

Примерно може да се налага често да се добавят нови конни надбягвания, но не и да се добавят нови градове,
в които да се извършват тези надбягвания.  
Може да се налага да се търсят участниците подредени по брой спечелени състезания и тнт.

В тази лекция ще разгледаме някои от основните структури от данни и тяхните имплементации в Java.

> ℹ️ За повече информация относно това какво са структурите от данни 
вижте това [youtube видео](https://www.youtube.com/watch?v=bum_19loj9A).


#### Arrays (Масиви)

Масивът е една от най-простите структури от данни.  
Представлява последователна поредица от елементи с фиксиран размер.
Знаем че всеки елемент може да бъде достъпван използвайки индекс.

![array](../../../assets/12-lecture/array.png)

- Предимства
    - Константно `O(1)` време за достъпване на елемент в масива използвайки индекс.
    - Може да съдържа множество елементи.
    
- Недостатъци
    - Статична структура с фиксиран размер. Не може да се добавят повече елементи от размера на масива.
    - Необходимо е да знаем размера на масива преди да го създадем.

> Масивът често е използван, като основа за изграждането на по-сложни структури от данни.

#### List (Списък)

Списъкът е следващата структура от данни, която директно надгражда масива.
Тя цели да реши проблема с фиксирания размер на масива (в някои езици за програмиране е познато, като 
динамичен масив).

При него не e нужно да знаем първоначалния размер на списъка и можем да добавяме елементи, като самият списък
ще се погрижи сам за това, когато масивът бъде запълнен да задели нов масив с по-голям размер, да копира старите
стойности в новия масив и да добави новия елемент.

В Java `List` е интерфейс, който има много на брой имплементации. В тази лекция ще разгледаме някои от тях.

##### ArrayList

`ArrayList` е имплементация на интерфейса `List`. Това е динамичен списък, който вътрешно използва масив.
Привидно списъка има размер `size`, който представлява броя елементи добавени в списъка. 
Това е числото 4 от снимката по-долу. В същото време има вътрешно property `capacity`, което представлява
истинския размер на масива. Не е задължително `size` и `capacity` да са с една и съща стойност.


![dynamic_array](../../../assets/12-lecture/dynamic_array.svg).

> ℹ️ За повече информация вижте това [youtube видео](https://www.youtube.com/watch?v=qTb1sZX74K0).

- Предимства
    - Не е необходимо да се знае предварително размера на масива
    - Бързо достъпване на елемент намиращ се на конкретен индекс
    - Бързо добавяне на елементи в края на списъка
    
- Недостатъци
    - Добавянето на елементи в началото или средата на масива изисква да преместване на елементите от дясно.
    - При достигане на капацитета на масива е необходимо да се създаде нов масив с по-голям размер 
    и да се копират старите стойности

**Пример**

```java
List<String> myArrayList = new ArrayList<>();

myArrayList.add("foo");
myArrayList.add("bar");
myArrayList.add("zar");
myArrayList.add("var");
myArrayList.add("far");

myArrayList.remove("bar"); // намери елемента "bar" и го премахни
myArrayList.remove(1); // премахни елемента на 1-ви индекс

for (String myString : myArrayList) {
    System.out.println(myString);
}
```

##### LinkedList

![linked_list_insertion_animation](../../../assets/12-lecture/linked_list_insertion_animation.gif)

> ℹ️ За повече информация вижте това [youtube видео](https://www.youtube.com/watch?v=_jQhALI4ujg).

**Пример**

```java
List<String> myLinkedList = new LinkedList<>();

myLinkedList.add("foo");
myLinkedList.add("bar");
myLinkedList.add("zar");
myLinkedList.add("var");
myLinkedList.add("far");

myLinkedList.remove("bar"); // намери елемента "bar"  и го премахни
myLinkedList.remove(1); // премахни елемента на 1-ви индекс

for (String myString : myLinkedList) {
    System.out.println(myString);
}
```

#### Stack

![stack_push_pop_animation](../../../assets/12-lecture/stack_push_pop_animation.gif)

**Пример**

```java
Stack<String> myStack = new Stack<>();

myStack.push("foo");
myStack.push("bar");
myStack.push("zar");
myStack.push("var");
myStack.push("far");

String lastElement = myStack.pop();// премахни последния добавен елемент

System.out.println("Last element: " + lastElement);

for (String myString : myStack) {
    System.out.println(myString);
}
```

#### Queue

![queue_enqueue_dequeue_animation](../../../assets/12-lecture/queue_enqueue_dequeue_animation.gif)

> ℹ️ За повече информация вижте това [youtube видео](https://www.youtube.com/watch?v=wjI1WNcIntg)

**Пример**

```java
Queue<String> myQueue = new LinkedList<>();

myQueue.add("foo");
myQueue.add("bar");
myQueue.add("zar");
myQueue.add("var");
myQueue.add("far");

String lastElement = myQueue.poll(); // премахни първия елемент

System.out.println("First element: " + lastElement);

for (String myString : myQueue) {
    System.out.println(myString);
}
```

#### Trees 

##### TreeSet

![binary_search_tree](../../../assets/12-lecture/binary_search_tree_animation.gif)

> ℹ️ За да придобиете по ясна представа, какво се случва, когато се добавят
и премахват елементи от дървета вижте това [youtube видео](https://www.youtube.com/watch?v=oSWTXtMglKE).

**Пример**

```java
TreeSet<String> myTree = new TreeSet<>();

myTree.add("foo");
myTree.add("bar");
myTree.add("zar");
myTree.add("var");
myTree.add("far");

myTree.remove("bar");// намира и премахва елемента bar

for (String myString : myTree) {
    System.out.println(myString); // обхождаме ги подредени
}
```

#### Set

##### HashSet

![hash_set](../../../assets/12-lecture/hash_set.png)

> ℹ️ За повече информация прочетете [тази статия](https://www.thecshandbook.com/hash_set)
или вижте това [youtube видео](https://www.youtube.com/watch?v=WPcKwA5WF7s).

**Пример**

```java
Set<Integer> mySet = new HashSet<>();

mySet.put(12);
mySet.put(20);
mySet.put(30);
mySet.put(30);
mySet.put(-15);

mySet.remove(20);

for (Integer number : mySet) {
    System.out.println(number); // обхождаме ги в неопределен ред
}
```

#### Hash Tables

##### HashMap

![hashmap](../../../assets/12-lecture/hashmap.jpg)

> ℹ️ За да придобиете по ясна представа, какво се случва, когато се добавят
и премахват елементи от hash tables вижте [това](https://www.youtube.com/watch?v=MfhjkfocRR0) 
и [това](https://www.youtube.com/watch?v=shs0KM3wKv8) youtube видео.

**Пример**

```java
Map<String, Integer> myMap = new HashMap<>();

myMap.put("foo", 1);
myMap.put("bar", 3);
myMap.put("zar", -4);
myMap.put("var", 8);
myMap.put("far", 12);

myMap.remove("bar");// намира и премахва елемента bar

for (String myKey : myMap.keySet()) { // обхождаме всички ключове
    System.out.println(myKey); // обхождаме ги в неопределен ред
}

for (int myValue : myMap.values()) { // обхождаме всички стойности
    System.out.println(myValue); // обхождаме ги в неопределен ред
}
```

##### Collections vs Maps

И колекциите и маповете целят да репрезентират структури от данни. Йерархично погледанто в Java
те са представени, като две различни звена (node) в йерархичното дърво.

![java_collections_and_map_hierarchy](../../../assets/12-lecture/java_collections_and_map_hierarchy.png)

#### Iterators

Общото м/у всички структури от данни, които разгледахме до тука е тяхното свойство те да бъдат итерирани.

Всяка една от структурите от данни може да участва в цикъл под един или друг вид.

В Java има интерфейс, който репрезентира способността да се итерира някаква съвкупност от данни.
Този интерфейс се нарича `Iterator`. 

Ето как изглеждаше той преди Java 8

```java
public interface Iterator<E> {
    
    boolean hasNext();
    
    E next();
     
    void remove();
}
```

> Итератора е удобен в случаите, когато е необходимо да се премахват елементи докато се итерира.
С нормален `for` цикъл това би било трудно.

Всяка една колекция има метод `Iterator<E> iterator();`, който връща итератора на колекцията.
Този итератор може да бъде ползван за итериране на колекцията.

Като методите на итератора предоставят 3 функционалности.

- `hasNext()` - проверява дали има следващ елемент

- `next()` - връща следващия елемент

- `remove()` - премахва текущия елемент, на който се намира итератора

**Пример**

```java
List<String> myList = ...;

Iterator<String> myListIterator = myList.iterator();

while (myListIterator.hasNext()) {   
    String currentElement = myListIterator.next();
    
    if ("removeMe".equals(currentElement)) {
       myListIterator.remove(); 
    }
}
```

> С Java 8 бяха добавени още няколко метода в интерфейса, които не са от значение за тази лекция.


#### Compare to

Често, когато се работи с даден тип данни се налага тези данни да се пазят в подреден вид.
Така например ако имаме списък с числа можем да ги подредим във възходящ или низходящ ред.
Това би ни позволило после по-бързо да търсим дали дадено число вече го имаме записано.

Тази подредба е интуитивна, когато се налага да се подреждат числа или текст (текста ще е по азбучен ред), но
когато става въпрос за типове данни, които моделират обекти от реалния свят е необходимо изрично да се опише, как ще се
извършва тази подредба.

Нека разгледаме един пример, в който се налага да пазим подреден списък от Хора (Person). Преди да бъде подреден 
този списък, е необходимо да определим по-какво ще бъдат подреждани елементите в него. 
Може да бъдат подреждани по възраст (age), височина (height), цвят на очите (eye color) и тнт...

Това как се сравняват 2 елемента за да могат те да бъдат подредени в някаква структура от данни се описва от интерфейса
`Comparable`. 

```java
public interface Comparable<T> {

    int compareTo(T other);

}
```

Интерфейса има само 1 метод `compareTo`, който примеа елемента, с който ще бъде сравняван текущия елемент и връща `int`,
като резултат. Класът имплементиращ този интерфейс е длъжен да върне `-1`, `0` или `+1` ако текущия елемент е по-малък,
равен или по-голям от другия.

**Пример**

```java
class Person implements Comparable<Person> {
    
    private int age;
    
    public Person(int age) {
        this.age = age;
    }
    
    @Override
    public int compareTo(Person other) {
        if (this.age < other.age){
            return -1;
        }
        
        if (this.age == other.age){
            return 0;
        }
        
        return 1;
    }
}
```


## Tasks

### Task 1

Създайте програма, която взема от потребителя неопределен брой числа, докато не бъде въведено `-1`.  
При въвеждане на `-1` от потребителя, числата, които той е въвел да бъдат изписани в обратен ред,  
както и да се намери най-малкото въведено число и да се принтира.

- Пример

```text
Въведете число: 32
Въведете число: -8
Въведете число: 12
Въведете число: 0.5
Въведете число: -1

Резултат: 0.5 12.0 -8.0 32.0 
Най-малкото число е: -8.0
```

> Използвайте `List<Integer> numbers = new ArrayList<>();` за да решите задачата.

<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

- Task1.java

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {

    private static final double STOP_NUMBER = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> myNumbers = new ArrayList<>();

        double min = STOP_NUMBER;

        while (true) {
            System.out.print("Въведете число: ");
            double currentNum = scanner.nextDouble();

            if (currentNum == STOP_NUMBER) {
                break;
            }

            if (min == STOP_NUMBER) {
                min = currentNum;
            } else if (min > currentNum) {
                min = currentNum;
            }

            myNumbers.add(currentNum);
        }

        System.out.printf("%nРезултат: ");
        for (int i = myNumbers.size() - 1; i >= 0; i--) {
            double element = myNumbers.get(i);

            System.out.print(element + " ");
        }

        System.out.printf("%nНай-малкото число е: " + min);
    }
}
```

</p>
</details>

### Task 2

Създайте програма, която принтира уникалните думи, които потребителя е въвел.
Потребителя може да въвежда дума по дума или да въведе цяло изречение.
Всеки път, когато потребителя въведе дума, която преди е въвеждал да се изпише, че въпросната дума вече е въведена.

Въвеждането приключва, когато потребителя въведе `stop`. След, което се принтират всички уникални думи.
Редът на изписване е без значение.

- Пример
  
```text
Въведете текст: мач
Въведете текст: чаша
Въведете текст: сипи вино
Въведете текст: обичам вино
Думата 'вино' вече е въведена.
Въведете текст: чаша
Думата 'чаша' вече е въведена.
Въведете текст: stop

Резултат: мач чаша обичам сипи вино
```

> Използвайте `Set<String> words = new HashSet<>();` за да записвате думите, 
както и `String[] words = text.split(" ");` за да разделите въведения от потребителя текст на думи.

<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

- Task2

```java
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> uniqueWords = new HashSet<>();

        boolean shouldPromptUser = true;
        while (shouldPromptUser) {

            System.out.print("Въведете текст: ");
            String sentence = scanner.nextLine();

            String[] words = sentence.split(" ");

            for (String currentWord : words) {

                if ("stop".equals(currentWord)) {
                    shouldPromptUser = false;
                    break;
                }

                if (uniqueWords.contains(currentWord)) {
                    System.out.printf("Думата '%s' вече е въведена.%n", currentWord);
                } else {
                    uniqueWords.add(currentWord);
                }
            }
        }

        System.out.printf("%nРезултат: ");
        for (String eachUniqueWord : uniqueWords) {
            System.out.print(eachUniqueWord + " ");
        }
    }
}
``` 

</p>
</details>

### Task 3

Напишете програма, която бори колко пъти е въведена дадена дума от потребителя.  
Въвеждането на данни приключва, когато потребителя въведе `stop`, след което се
принтира най-често въведената дума.

**Пример**

```text
Въведете текст: котка
Въведете текст: куче
Въведете текст: раница
Въведете текст: куче
Въведете текст: котка и куче
Въведете текст: stop

Най-често срещана дума е: куче
```

> Използвайте `Map<String, Integer> wordCount = new HashMap<>();` за да броите всяка дума, колко пъти е въвеждана.
За ключ ползвайте думата, а за стойност броя повторения на тази дума.

<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> wordCount = new HashMap<>();

        while (true) {
            String word = scanner.nextLine();

            if ("stop".equalsIgnoreCase(word)) {
                break;
            }

            Integer occurrence = wordCount.get(word);

            if (occurrence == null) {
                wordCount.put(word, 1);
            } else {
                wordCount.put(word, occurrence + 1);
            }
        }

        String maxWord = null;
        int max = 0;

        for (Map.Entry<String, Integer> currentEntry : wordCount.entrySet()) {

            String currentWord = currentEntry.getKey();
            int occurrence = currentEntry.getValue();

            if (max < occurrence) {
                maxWord = currentWord;
                max = occurrence;
            }
        }

        System.out.println("Most frequent word is '" + maxWord + "' with " + max + " occurrences.");
    }
}
```

</p>
</details>

### Task 4

Напишете задача, която е способна да тълкува [Reverse Polish Notation](https://bg.wikipedia.org/wiki/%D0%9E%D0%B1%D1%80%D0%B0%D1%82%D0%B5%D0%BD_%D0%BF%D0%BE%D0%BB%D1%81%D0%BA%D0%B8_%D0%B7%D0%B0%D0%BF%D0%B8%D1%81).
RPN е математически запис, използван от калкулаторите, за да решават уравнения.  
Записа е характерен с това че първо се изписват операндите после операторите.

- Примери

1. `3 + 4` би се изписало `3` `4` `+` (това означава числото 3 и числото 4 да се събере)
2. `3 - 20` би се изписало `3` `20` `–` (това означава от 3 извади 20) 
3. `3 – 4 + 5`  би се изписало `3` `4` `–` `5` `+` (това означава от 3 извади 4, 
от резултата на това изваждане прибави 5)
4. `3 – (4 * 5)` би се изписало `3` `4` `5` `*` `–` (това означава първо умножи 4 и 5 и
получения резултат след това го извади от 3  или това е същото, като `3` `20` `–` )
5. `(3 – 4) * 5` би се изписало `3` `4` `–` `5` `*`

**Решете примерите 1 и 2**  
При условие че вече имате получения запис в RPN напишете програма, която да може да тълкува този запис
и да извършва правилно матиматическите изчисления.

<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

```java
import java.util.Arrays;
import java.util.Stack;

public class RPMDemo {
    
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        stack.push("3");
        stack.push("4");
        stack.push("+");

        String item = stack.pop();

        handleItem(stack, item);

        System.out.println(Arrays.toString(stack.toArray()));
    }

    private static void handleItem(Stack<String> stack, String operator) {

        if (isOperator(operator)) {

            String operand2 = stack.pop();
            String operand1 = stack.pop();

            double value1 = Double.parseDouble(operand1);
            double value2 = Double.parseDouble(operand2);

            double result = handleOperator(value1, value2, operator);

            stack.push(Double.toString(result));
        }
    }

    private static double handleOperator(double value1, double value2, String operator) {
        if ("+".equals(operator)) {
            return value1 + value2;
        }

        if ("-".equals(operator)) {
            return value1 - value2;
        }

        if ("*".equals(operator)) {
            return value1 * value2;
        }

        return value1 / value2;
    }

    private static boolean isOperator(String item) {
        return "+".equals(item)
                || "-".equals(item)
                || "*".equals(item)
                || "/".equals(item);
    }
}
```

</p>
</details>

> ℹ️ За повече информация как да се реши тази задача вижте това 
[youtube видео](https://www.youtube.com/watch?v=7ha78yWRDlE).

### Task 5

Напишете програма, която симулира работата на ферма за птици (Chicken Barn).  
🥚 &rarr; 🐤 &rarr; 🐓 &rarr; ⚰️

В една ферма първоначално може да има определен брой кокошки (например 5).  

- Всяка кокошка снася по едно яйце всяка седмица.

- Една кокошка може да снася яйца само ако е м/у 2-8 седмици.

- Яйце което е навършило 2 седмици се излюпва, добавяйки нова кокошка във фермата. 
  Името на излюпената кокошка зависи от името на предишната кокошка.  
  
  **Пример:** 
  ако кокошката снесла яйцето се казва `Chicken1`, то излюпената кокошка може да се казва
  `Chicken1/ChickenX` където `X` е номера на кокошката.

- При навършване на 9 седмици, кокошката умира и се премахва от фермата.

Програмата трябва да принтира кокошките, които са останали във фермата след определен брой седмици.

**Пояснение**

Една седмица преминава като:
1. Увеличава се възрастта на снесените яйца
2. Излюпват се яйцата, които са навършили необходимата възраст
3. Увеличава се възрастта на кокошките
4. Премахват се кокошките, които са навършили 9 седмици
5. Снасят се яйца от кокошките навършили необходимата възраст
6. Започва следващата седмица

- Пример при 4 начални кокошки съответно на възраст от  4, 5, 6, 7 седмици и общо време за развитие 4 седмици

```text
Chicken{name='Chicken1'}
Chicken{name='Chicken1/Chicken5'}
Chicken{name='Chicken2/Chicken6'}
Chicken{name='Chicken3/Chicken7'}
Chicken{name='Chicken4/Chicken8'}
Chicken{name='Chicken1/Chicken9'}
Chicken{name='Chicken2/Chicken10'}
Chicken{name='Chicken3/Chicken11'}
```

- Пример при 3 начални кокоши съответно на възраст от 3, 4, 5 седмици и общо време за развитие 4 седмици

```text
Chicken{name='Chicken1'}
Chicken{name='Chicken2'}
Chicken{name='Chicken1/Chicken4'}
Chicken{name='Chicken2/Chicken5'}
Chicken{name='Chicken3/Chicken6'}
Chicken{name='Chicken1/Chicken7'}
Chicken{name='Chicken2/Chicken8'}
Chicken{name='Chicken3/Chicken9'}
```

<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

- Main.java

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        List<Chicken> chickens = new ArrayList<>();

        chickens.add(new Chicken(3)); // добави кокошка на 3 седмици
        chickens.add(new Chicken(4)); // добави кокошка на 4 седмици
        chickens.add(new Chicken(5)); // добави кокошка на 5 седмици

        Barn barn = new Barn(chickens); // създай ферма подавайки кокошките

        List<Chicken> evolvedChickens = barn.evolve(4); // итерирай 4 седмици във фермата

        for (Chicken chicken : evolvedChickens) { // принтирай всички кокошки след 4-те седмици
            System.out.println(chicken);
        }
    }
}
```

- Egg.java

```java
public class Egg {
    private static final int HATCHING_WEEK = 2;

    private String chickenName;
    private int age;

    /**
     * Конструктор, за създаване на ново яйце.
     *
     * @param chickenName името на кокошката снесла яйцето.
     */
    public Egg(String chickenName) {
        this.chickenName = chickenName;
        age = 0;
    }

    /**
     * Увеличи възрастта на яйцето с 1 седмица.
     */
    public void ageByOneWeek() {
        age++;
    }

    /**
     * Излюпи яйцето, ако е навършило необходимата възраст.
     *
     * @return излюпената кокоша или null, ако яйцето не може да бъде излюпено.
     */
    public Chicken hatch() {
        if (age < HATCHING_WEEK) {
            return null;
        }

        return new Chicken(chickenName);
    }
}
```

- Chicken.java

```java
public class Chicken {
    private static final int DEATH_WEEK = 9;
    private static final int MIN_HATCH_WEEK = 2;
    private static final int MAX_HATCH_WEEK = 8;

    /* Статична променлива, която се използва в името на кокошката.
     * Всеки път, когато се създаде нова кокошка, тази променлива се увеличава с 1.
     */
    private static int ID_SEQUENCE = 1;

    private final String name;

    private int age;

    /**
     * Създай нова кокошка назначавайки и служебно име и подадаената възраст.
     *
     * @param age възрастта на кокошката в седмици.
     */
    public Chicken(int age) {
        this.name = getNextName("");
        this.age = age;
    }

    /**
     * Конструктор създадващ новородена кокошка. Конструкторът приема името на кокошката, която е снесла
     * яйцето. На база това име ще се определи името на тази кокошка.
     *
     * @param chickenName името на кокошката снесла яйцето.
     */
    public Chicken(String chickenName) {
        this.name = getNextName(chickenName + "/");
        this.age = 0;
    }

    /**
     * Метод връщащ името на кокошката съставено от prefix + "Chicken" + ID, където ID е поредния
     * номер на кокошката.
     *
     * @param prefix текст, който да бъде използван пред името на кокошката.
     * @return ново име на кокошка.
     */
    private String getNextName(String prefix) {
        return prefix + "Chicken" + ID_SEQUENCE++;
    }

    /**
     * Този метод проверява дали кокошката е навършила необходимата възраст за да умре.
     *
     * @return true ако е навършила преклонна възраст, false в противен случай.
     */
    public boolean canDie() {
        return age >= DEATH_WEEK;
    }

    /**
     * Този метод връща яйце, ако кокошката е навършила зряла възраст и може да снася яйца.
     * Снесеното яйце има името на кокошката, която го е снесла.
     *
     * @return снесеното яйце или null ако кокошката не може да снася.
     */
    public Egg hatchEgg() {
        if (age < MIN_HATCH_WEEK || age > MAX_HATCH_WEEK) {
            return null;
        }

        return new Egg(name);
    }

    /**
     * Този метод увеличава възрастта на кокошката с една седмица.
     */
    public void ageByOneWeek() {
        this.age++;
    }

    @Override
    public String toString() {
        return "Chicken{" +
                "name='" + name + '\'' +
                '}';
    }
}
```

- Barn.java

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Barn {
    private List<Chicken> chickens;
    private List<Egg> eggs;

    /**
     * Конструктор, който инициализира фермата с подадените през него кокошки.
     * Когато се създаде нова ферма, в нея няма яйца.
     *
     * @param chickens първоначалните кокошки във фермата.
     */
    public Barn(List<Chicken> chickens) {
        this.chickens = chickens;
        this.eggs = new ArrayList<>();
    }

    /**
     * Този метод развива фермата с определен брой седмици.
     *
     * @param weeks броя седмици, с които да бъде развита фермата.
     * @return връща списъкът с кокошки след развитието.
     */
    public List<Chicken> evolve(int weeks) {
        for (int week = 0; week < weeks; week++) {
            hatchEggs();
            growChickens();
        }

        return chickens;
    }

    /**
     * Този метод репрезентира, какво се случва през една седмица с яйцата.
     * Методът обикаля всички налични яйца, увеличава им възрастта с 1 седмица,
     * излюпва яйцата, които са годни и добавя излюпените кокошки в списъка с кокошки.
     */
    private void hatchEggs() {
        Iterator<Egg> iterator = eggs.iterator();

        while (iterator.hasNext()) {
            Egg currentEgg = iterator.next();

            currentEgg.ageByOneWeek();
            Chicken newChicken = currentEgg.hatch();

            if (newChicken != null) {
                chickens.add(newChicken);

                iterator.remove();
            }
        }
    }

    /**
     * Този метод репрезентира, какво се случва през една седмица с кокошките.
     * Методът обикаля всички налични кокошки, увеличава им възрастта с 1 седмица
     * Премахва кокошките на преклонна възраст и снася яйца използвайки кокошките на зряла възраст,
     * като добавя излюпените яйца в списъка с яйца..
     */
    private void growChickens() {
        Iterator<Chicken> iterator = chickens.iterator();

        while (iterator.hasNext()) {
            Chicken currentChicken = iterator.next();

            currentChicken.ageByOneWeek();

            if (currentChicken.canDie()) {
                iterator.remove();
            }

            Egg egg = currentChicken.hatchEgg();
            if (egg != null) {
                eggs.add(egg);
            }
        }

    }
}
```

</p>
</details>
