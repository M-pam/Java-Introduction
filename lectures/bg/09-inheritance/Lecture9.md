# Lecture 9
#java course#

## Inheritance (Наследяване) 🏛️

Наследяването е вторият основен принцип на ООП след енкапсулация. Проблема, който цели да реши
е да направи по-лесно преизползването на логика написана в различни класове. Начина, по който се постига
това преизползване чрез ООП, е като се изгражда йерархична връзка м/у отделните класове.

- Например

![inheritance-illustration](../../../assets/09-lecture/inheritance-illustration.png)
> Имаме една абстракция за животно, като имаме два конкретни представителя на тази абстракция и те са Куче и Котка.  
Или с други думи казваме че Куче и Котка наследяват абстракцията Животно

![4-pillars-of-oop](../../../assets/09-lecture/4-pillars-of-oop.png)
> Четирите основни принципа на ООП

При наследяването имаме `super class`, който представлява по-високото ниво в йерархията и наследяващ клас `child class`,
който представлява по-ниското ниво в йерархията. Така `child` (дете) класът наследява `super` класът.

В примера по-горе `Animal` е `super class`, а `Dog` и `Cat` са `child` класове на `Animal`.

### Какво може да бъде преизползвано чрез наследяване?

Когато един клас наследява друг клас наследника получава достъп до:

- methods (методи)
- properties (свойства)
- constructors (конструктори)

По този начин общата логика м/у отделните наследници може да бъде написа в `super` класът, а всички наследници 
на този клас да я преизползват.

Наследяването се осъществява чрез ключовата дума `extends`, която се изписва на нивото на класът.

- Пример

    - Animal.java (`super class`)
    
    ```java
    public class Animal {
    
        public int age;
    
        public void eat() {
            System.out.println("Eating...");
        }
    }
    ```
    
    > `Animal` класът дефинира property `age` и method `eat()`, които ще бъдат достъпни
    в `child` класовете
    
    - Dog.java (`child class`)
    
    ```java
    public class Dog extends Animal {
    
        public String breed;
    
        public void bark() {
            System.out.println("Woff woff...");
        }
    
        public void printDetailsAndEat() {
            // age е дефинирано в супер класът
            System.out.println("Breed: " + breed + " " + "Age: " + age);
    
            eat(); // този метод е дефиниран в супер класът
        }
    }
    ```
    
    > `Dog` наследява `Animal`, като класът дефинира ново property `breed` (порода), method `bark()` (лая)
    и method `printDetailsAndEat()`, които са достъпни само в `Dog` класът. 
    `Dog` също така получава достъп до `age` и `eat()` от супер класът.
    
    - Cat.java (`child class`)
    
    ```java
    public class Cat extends Animal {
    
        public int numberOfLives;
    
        public void purr() {
            System.out.println("PurRrRr...");
        }
    
        public void printDetailsAndEat() {
            // age е дефинирано в супер класът
            System.out.println("Num of Lives: " + numberOfLives + " " + "Age: " + age);
    
            // този метод е дефиниран в супер класът
            eat();
        }
    }
    ```
    
    > `Cat` наследява `Animal`, като класът дефинира ново property `numberOfLives` (брой животи), method `purr()` (мърка)
    и method `printDetailsAndEat()`, които са достъпни само в `Cat` класът. 
    `Cat` също така получава достъп до `age` и `eat()` от супер класът.
    

### Method Overloading
В Java можем да създадем два метода с еднакво име, еднакви return типове, но различни на брой или тип входни параметри.
Като методът, който ще бъде извикан се определя от входните параметри, които биват подавани.

Това свойство на Java се нарича Method Overloading.

- Пример

    ```java
    class Foo {
        void doSomething(int a) {
            System.out.println(a);
        }
        
        void doSomething(String a) {
            System.out.println(a);
        }
        
        void doSomething(int a, String b) {
            System.out.println(a + " " + b);
        }
    }
    ```
    > В този случай казваме, че методът `doSomething` е overload-нат

### Constructors and chaining

Ще разгледаме в повече детайли как можем да обвържем няколко конструктора на един и същи клас.
Като примерите, които ще разгледаме ще са за клас, който не наследява нищо и клас, който наследява друг клас.

Логически **constructor chaining** може да се разглежда, като **method overloading**. 
Като задължително при извикването на първия конструктор се извиква и втория и третия ако има такъв и тнт...

#### Constructor chaining без наследяване

Ако един клас има 2 конструктора, то ние сме задължени, когато инстанцираме класът да използваме един от 2-та конструктора.
Така например единия конструктор може да приема 2 параметъра, а другия 3.  
Възможно е да навържем така първия конструктор, че той да предава 2-та параметъра на конструктора с 3 параметъра.  
Това става с помощта на ключовата дума `this`.

- Пример

    ```java
    class Person {
        
        final String firstName;
        final String middleName;
        final String lastName;
        
        Person(String firstName) {
            this(firstName, null); // конструкторът с 1 параметър извиква конструктора с 2 параметъра
        }
        
        Person(String firstName, String lastName) {
            this(firstName, null, lastName); // конструкторът с 2 параметъра извиква конструктора с 3 параметъра
        }
      
        Person(String firstName, String middleName, String lastName) {
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
        }
       
    }
    ```
    
В случаят използваме ключовата дума `this` в 2 от конструкторите като метод `this(param1, param2)`. 
В третия конструктор с три параметъра използваме ключовата дума `this` за да достъпим свойствата на класа.

#### Constructor chaining с наследяване

Ако имаме `super class`, който дефинира 1 конструктор всички наследници са длъжни да извикат този конструктор,
при тяхното инстанциране. Това става чрез ключовата дума `super` в конструктора на `child` класът.

- Пример

    ```java
    class Person {
      
        final String firstName;
        final String lastName;
        final boolean isMale;
    
        Person(String firstName, String lastName, boolean isMale) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.isMale = isMale;
        }
    }  
  
    class Male extends Person {
            
        Male(String firstName, String lastName) {
            super(firstName, lastName, true); // извикваме конструктора на Person с ключовата дума super
        } 
    }
    ```
    
В случая ползваме ключовата дума като метод `super(param1, param2, param3)`, обаче тя може да бъде ползвана и
за достъпване на методи и променливи от super класът.
    
### Java Object class

В Java всичко наследява класът `Object`. Той е супер класът на всеки един клас.

От този клас получаваме няколко често използвани метода:

- toString
- equals
- hashCode

### toString

Сигнатурата на този метод е следната `String toString()`. Този метод се използва, когато искаме да получим
текстова репрезентация на даден обект. Имплементацията на `toString` идваща от `Object` класът, връща текстовата
репрезентация на адреса на обекта в паметта. За това когато принтираме със `System.out.println(myObject)`
се принтира адреса на обекта вместо неговото съдържание.

> Знаете ли че `System.out.println()` извиква `toString` метода на класът.

### equals

Сигнатурата на този метод е следната `boolean equals(Object otherObject)`. Този метод се използва, когато искаме
да проверим дали една инстанция на обект е равна на друга инстанция. Методът приема 1 параметър 
(обектът срещу който ще се сравнява) и връща `boolean` резултат. true ако са еднакви false в противен случай.
Имплементацията на `equals` идваща от `Object` класът сравнява адресите на променливите вместо да сравнява съдържанието
на променливите.

### hashCode

Сигнатурата на този мето е следната `int hashCode()`. Този метод се използва когато [хешираме][hash-function]
даден обект. Целта на това хеширане е да прекараме данните на един обект през математически функции и да получим
число. Това число може да бъде използвано като числова репрезентация на данните. Като задължително крайния резултат
от хеширането на една и съща променлива n на брой пъти трябва да е еднакъв.

> Ще разгледаме хеширащите функции в повече детайли следващите лекции

[hash-function]: https://bg.wikipedia.org/wiki/%D0%A5%D0%B5%D1%88-%D1%84%D1%83%D0%BD%D0%BA%D1%86%D0%B8%D1%8F

### Method Overriding (пренаписване на метод)

Когато един клас наследява друг клас, то първия има възможността да пренапише функционалността на някои от методите
на super класът. Това нещо се нарича Override (презаписване/пренаписване).
Като за четимост методите, които биват пренаписани се обозначават с `@Override` над сигнатурата им.

- Пример

    ```java
    class Animal {
        
        void speak() { // класът Animal дефинира метод speak
            System.out.println("Speaking...");
        }
    }
    
    class Dog extends Animal { // Dog наследява Animal
        
        @Override   // обозначаваме че методът е пренаписан и идва от super класът
        void speak() { // Класът Dog пренаписва (override) методът speak от класът Animal
            System.out.println("Woff woff...");
        }
    }
    ```
    
    > `new Animal().speak()` ще изпише `Speaking...`, а `new Dog().speak()` ще изпише `Woff woff...`
