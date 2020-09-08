# Lecture 10
#java course#

## Inheritance Exercises and Theory 

### Design Patterns

В софтуерното инженерство **design pattern** (шаблон на дизайн) е прилагането на определен тип решение,
на често срещан проблем. Това решение не е конкретен код, а по скоро описание как да се реши този проблем.

> ℹ️ За повече информация прочетете [тук](https://sourcemaking.com/design_patterns).

#### Singleton

Това е **design pattern**, който цели да гарантира, че ще има само 1 инстанция от даден `class` във всеки един
момент от време на изпълнение на програмта.

###### Пример (Eager Singleton)

```java
public final class Universe {

    // статична final променлива, в която веднага създаваме инстанцията
    public static final Universe INSTANCE = new Universe();

    // private конструктор, за да не може друг да инстанцира този клас
    private Universe() {
    }
}
```

```java
public class Main {

    public static void main(String[] args) {

        // достъпваме единствената инстанция
        Universe singleInstance = Universe.INSTANCE;
    }
}
```

###### Пример (Lazy Singleton)

```java
public final class Universe {

    // статична final променлива, в която по късно ще се запише инстанцията
    private static Universe INSTANCE;

    // private конструктор, за да не може друг да инстанцира този клас
    private Universe() {
    }

    /**
     * Метод, който предоставя единствената инстанция на този клас.
     * Инстанцията ще бъде създадена при първото извикване на този метод.
     *
     * @return единствената инстанция на този клас.
     */
    public static Universe getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Universe();
        }

        return INSTANCE;
    }
}
```

```java
public class Main {

    public static void main(String[] args) {

        // достъпваме единствената инстанция
        Universe singleInstance = Universe.getInstance();
    }
}
```

#### Inheritance vs Composition

Едно от фундаменталните неща в ООП е да се изграждат връзки (моделират) м/у отделни класове. 
Наследяване и композиция са два от основните начини по, които могат да бъдат изградени тези връзки.
И двата подхода целят да предоставят механизъм за преизползване на функционалност (код).

Можем да кажем използваме наследяване, когато един клас наследява друг клас за да преизползва неговата функционалност.

###### Наследяване

```java
class Apple extends Fruit {
    
}

class Fruit {
    
    int peel() {
        // някаква сложна логика
    }
}

class Main {
    
    public static void main(String[] args){
      Apple apple = new Apple();
      apple.peel();
    }
}
```

> В този случай `Apple` наследява `Fruit` и получава достъп до неговата функционалност.

###### Композиция

```java
class Apple {
    Fruit fruit; // ябълката е композирана от Fruit
    
    int peel(){
        fruit.peel(); // преизползване на логиката от класа Fruit
    }
    
}

class Fruit {
    
    int peel() {
        // някаква сложна логика
    }
}

class Main {
    
    public static void main(String[] args){
      Apple apple = new Apple();
      apple.peel();
    }
}
```

В повечето случаи, каквото може да се направи с наследяване, може да бъде направено и с композиция.
Често в по-новите източници се споменава, че композицията е за предпочитане пред наследяването, това обаче не означава,
че това винаги е така.

Едно просто правило за определяне дали да се ползва наследяване или композиция е чрез задаването на въпроса:
 `is a or has a? (това е или това има)`.

**Пример:** Ябълката **е** плод или ябълката **има** плод? В този случай според това правило трябва да се ползва
наследяване, защото ябълката **е** плод. 

> ℹ️ За повече информация прочетете [тук](https://www.javaworld.com/article/2076814/inheritance-versus-composition--which-one-should-you-choose-.html)
и [тук](https://stackoverflow.com/questions/49002/prefer-composition-over-inheritance).

#### SOLID

SOLID е акроним отговарящ на няколко основни принципа в ООП

- **S**ingle Responsibility Principle
- **O**pen Closed Principle
- **L**iskov Substitution Principle
- **I**nterface Segregation Principle
- **D**ependency Inversion Principle

> ℹ️ За повече информация прочетете [тук](https://medium.com/@dhkelmendi/solid-principles-made-easy-67b1246bcdf)
или изгледайте това [youtube видео](https://www.youtube.com/watch?v=TMuno5RZNeE).

#### Други често прилагани принципи и шаблони

- **DRY**
- **KISS**
- **YAGNI**
- **Law of Demeter**
- **Robustness principle (Postel's Law)**
- **Law of Demeter**
- **Occam’s Razor**
- **POJO**
- **Immutability**
- **Overengineering**
- **Dependency Injection**

### Anti Patterns

Съществуват също така често прилагани практики (patterns) в писането на код, които се смятат за лоши.
Това са така наречените Anti Patterns.

Ето няколко примера за такива

#### Java Beans Pattern

Това е мнго широко разпространен pattern, който гласи един клас трябва да има default constructor, private properties,
getters и setters (методи които могат да записват стойности и да четат стойности)

> ℹ️ За повече информация прочетете [тук](https://nicogiangregorio.wordpress.com/2012/12/28/javabeans-an-anti-pattern-or-not/).

#### Magic Numbers & Strings

Това е конвенция, която препоръчва стойности, с неясен произход и значение, записани (hardcoded) в кода 
да бъдат изнесени като променливи и да бъде дадено описателно име на променливата.

###### Магическо число 52

```java
class Deck {
    
    int getRandomCard() {
        return (int) (Math.random() * 52); // не е ясно защо e използвано точно числото 52
    }    
}
```

###### Магическо число изнесено в променлива

```java
class Deck {
    
    private final static int DECK_SIZE = 52; // 52 е размера на тесте карти
    
    int getRandomCard() {
        return (int) (Math.random() * DECK_SIZE);
    }    
}
```

### Recursion

Един метод може да извика сам себе си. Това самоизвикване на методи се нарича рекурсия.
Необходимо условие за една рекурсия е тя да има край, или така нареченото дъно.
В противен случай ще се получи безкрайна рекурсия. Рекурсията е просто още един начин, чрез който може да се постигне 
итеративно решаване на даден проблем. Всеки проблем, който може да бъде решен рекурсивно, 
може да бъде решен и итеративно (с цикъл) и обратното.

Това, което е важно да се спомене, е че при рекурсия, която не може да достигне дъното си ще се получи грешка.
Това е така, защото всяко едно извикване на метод в програмата заделя памет в [stack](#stack-vs-heap), 
който ще бъде изчерпан в даден момент от време.

> ℹ️ За по-детайлно обяснение
изгледайте това [youtube video](https://www.youtube.com/watch?v=Mv9NEXX1VHc).

###### Fibonacci
    
```java
private static int fibonacci(int n) {
    if (n <= 1) {
        return n; // дъно на рекурсията
    }
    
    return fibonacci(n - 1) + fibonacci(n - 2); // всяко едно извикване на метода fibonacci поражда други 2 извиквания
}
```    
    
![recursive_fibonacci_call_stack](../../../assets/10-lecture/recursive_fibonacci_call_stack.png)    

> Как изглеждат породените рекурсивни извиквания на fibonacci.


### Stack vs Heap

Ще разгледаме как Java езикът е рализирал изпълнението на една програма. Как точно са се случва извикването на методи,
подаването на параметри, следенето до къде е стигнало изпълнението на програмата и как се заделя и освобождава памет.

#### Stack

**Stack** е подредена структора от данни тип LIFO (last in first out (последният влязъл е първият излязъл)).
Стека в конетекста на памет се използва за записването на така наречения **Stack Frame**.

Java нарича **Stack Frame** моделировата на извикването на даден метод от програмата. 
Като тази моделировка се състои от:
- параметри на метода
- локални променливи (променливи видими само за метода)
- допълнителна информация като return адрес

![stack_representation](../../../assets/10-lecture/stack_representation.jpg)

#### Heap

**Heap** в контекста на памет е неподредено пространство 
(има струкра от данни с име Heap, в момента **не** обсъждаме нея), което служи за записване на съдържанието 
на референтни типове. Заделянето на памет в heap-a става чрез ключовата дума `new`.

![stack_vs_heap_representation](../../../assets/10-lecture/stack_vs_heap_representation.png)

> Stack е подреден, докато Heap не е

Алокиране (заемане) на памет по време на изпълниене на програмата.

![alocated_stack_and_heap_presentation](../../../assets/10-lecture/alocated_stack_and_heap_presentation.gif)

В Stack-а се записва информация, като кои след кои методи са изпълнени, кой метод е в момента за изпълнение, 
какви са параметри на тези методи и с какви променливи борави всеки един метод. Променливите от референтен тип, 
които са записани в Stack-a представляват адреса на стойността на тази променлива намираща се в Heap-a.

> ℹ️ За по детайлно обяснение вижте това [youtube видео](https://www.youtube.com/watch?v=_8-ht2AKyH4).

### Garbage Collection

Процесът на работа на една програма е обикновенно следния.
1. Заделяне на пространство в паметта
2. Записване на някаква стойност в тази памет
3. Обработка на стойността

Често след третата стъпка не е необходимо повече да се обработва тази стойност. Това би означавало че в паметта остават
места, които са заделени и не могат да бъдат използвани.
За да може да се реши този проблем е необходимо да се извърши почистване на паметта, 
която не е използвана (реферирана) от никой. Тук вече навлиза **Garbage Collection**. 
Това е механизъм за почистване на паметта, който е заложен в езика Java. Той оперира в/у Heap-а.

![garbage_collection](../../../assets/10-lecture/garbage_collection.jpg)

> ℹ️ За повече информация прочетете [Java Garbage Collection Basics](https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/index.html)
и [Getting Started with the G1 Garbage Collector](https://www.oracle.com/technetwork/tutorials/tutorials-1876574.html).

[garbage-collection-vid]: https://www.youtube.com/watch?v=UnaNQgzw4zY

### Exercises

#### Task 1
Създайте програма, която симулира магазин. 🛒

Един магазин може да зарежда стока и да продава налична стока.

Задачата е съставена от няколко подточки.
Всяка следваща подточка от програмата зависи от предходната.

Програмата трябва да бъде решавана поетапно (точка по точка).
Всяка следваща подточка внася промяна в предишната.
Целта на задачата е да се упражнят натрупаните знания и способността да се 
моделират решения, които постоянно търпят промяна.

##### 1.1

- Един магазин (Shop) може да бъде зареждана (add) със стока.
    - Когато се зарежда стоката се казва името на стоката (productName) и цената (price).

- От магазина може да бъде купувана (buy) стока, като при закупуването се издава касова бележка (purchase receipt). 
    - Купуването става чрез упоменаване името на стоката и сума пари.
    - При успешно закупуване, магазинът издава касова бележка състояща се от:
        - името на продукта, който е закупен
        - цената на продукта
        - ресто (разликата м/у платените пари и цената на продукта)
    - Един продукт може да бъде закупен само ако:
        - вече е зареден такъв продукт
        - сумата пари е достатъчна да покрие цената
    - Ако продукта не може да бъде закупен не се издава касова бележка.
    - При продаване на продукт, той се изчерпва от магазина.

##### 1.2

- При зареждане на стока се упоменава и количество (quantity), което е винаги положително число.
    - Пример: При заредени 2 банана могат да бъдат продадени 2-пъти по 1 банан.
    
- Възможно е последователно зареждане на една и съща стока в магазина.
    - Пример: 2-пъти се зареждат по 2 ябълки. След зареждането ще може 4 пъти да се продадът ябълки.
    - Ако има повторното зареждане от вече зареден продукт с друга цена,
    то тогава новата стока се разглежда, като нов артикул.
        - Пример: зареден  е 1 банан на цена от 3 лева, след което отново се зарежда 1 банан на 5 цена от лева,
        то тогава имаме 1 банан от 3 лева и 1 банан от 5 лева.
        - В този случай няма значение, от коя стока ще бъде продадено

##### 1.3

- При закупуване на стока е възможно да се упомене и количеството продукти, което да бъде закупено.
    - При закупуване на 2 банана от 3 лева, ще трябва да се заплатят 6 лева за да бъдат продадени.
    - След закупуването на 2 банана от 2 налични, бананите ще бъдат изчерпани
    - В касовата бележка е изписано и количеството закупени продукти.

##### 1.4

- Магазинът може да зарежда стока на промоционални цени, 2 за 1.
    - Пример заредени са шоколади 2 на цената на 1. Ако един шоколад струва 5 лева, то ще може да бъдат закупени 2 такива.
    - Този тип артикул може да бъде закупен, само ако бройката на закупуване е 2, 4, 6 и тнт...
        - Ако са заредени 4 шоколада с тази промоция, не могат да бъдат закупени 5 или 6 такива шоколада.

##### 1.5

- Магазинът може да зарежда стока на промоционални цени, 3 за 2.
    - Пример заредени са бисквити 3 на цената на 2. Ако една кутия бисквити струва 5 лева, то ще може да бъдат закупени 3 кутии за 10 лева.
    - Този тип артикул може да бъде закупен, само ако бройката на закупуване е 3, 6, 9 и тнт...
        - Ако са заредени 3 кутии бисквити с тази промоция, не могат да бъдат закупени 2 или 5 кутии.


<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

- ShopDemo.java
```java
public class ShopDemo {

    public static void main(String[] args) {

        Shop shop = new Shop();

        shop.add("banana", 20, 2); // зареждаме 2 банана, като цената за 1 е 20 пари
        shop.add("chocolate", new TwoForOnePrice(10), 2); // зареждаме 2 шоколад на промоция, където цената и за 2-та е 10 пари
        
        PurchaseReceipt bananaRecipe = shop.buy("banana", 20); // купуваме 1 банан като даваме 20 пари
        PurchaseReceipt chocolateRecipe = shop.buy("chocolate", 10, 2); // купуваме 2 шоколада за 10 пари

        System.out.println(bananaRecipe);
        System.out.println(chocolateRecipe);
    }
}
```

- Price.java

```java
package lecture10.homework.shop;

/**
 * Този клас моделира цена на даден продукт. Той е използван като super клас на промоционалните цени.
 * Основното нещо, което има в този клас е сумата пари която трябва да се заплати.
 */
public class Price {

    public final double price;

    public Price(double price) {
        this.price = price;
    }

    /**
     * Този метод проверява дали сумата, която е предоставена от клиента е достатъчна за да се закупи желаното
     * от него количество.
     *
     * @param amount   сумата пари на клиента.
     * @param quantity количеството което клиента иска да закупи.
     * @return true ако сумата е достатъчна, false в противен случай.
     */
    public boolean canBePaid(int amount, int quantity) {

        return calculateForQuantity(quantity) <= amount;
    }

    /**
     * Този метод изчислява каква сума пари трябва да се плати за да бъде закупен този продукт.
     *
     * @param quantity количеството, което се закупува.
     * @return сумата пари, необходима за закупуването.
     */
    public double calculateForQuantity(int quantity) {
        return price * quantity;
    }

    @Override
    public String toString() {
        return String.format("(%.2f)", price);
    }

    /**
     * Този метод е презаписан, за да може да се сравняват различните цени.
     *
     * @param other другата цена с която да се сравни.
     * @return true ако цените са еднакви, false в противен случай.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Price price1 = (Price) other;

        return Double.compare(price1.price, price) == 0;
    }
}
```

- TwoForOnePrice.java

```java
/**
 * Този клас моделира цена от тип 2 за 1, като той наследява базовия клас {@link Price}.
 */
public class TwoForOnePrice extends Price {

    public TwoForOnePrice(double price) {
        super(price); // извикваме super конструктора на Price, за да подадем цената
    }

    /**
     * Този метод презаписва функционалността от Price, тъй като логиката за продажба
     * на продукт в промоция е по различна.
     *
     * @param amount   сумата пари на клиента.
     * @param quantity количеството което клиента иска да закупи.
     * @return true ако сумата е достатъчна, false в противен случай.
     */
    @Override
    public boolean canBePaid(int amount, int quantity) {

        if (quantity < 2 || quantity % 2 != 0) {
            return false;
        }

        return calculateForQuantity(quantity) <= amount;
    }

    /**
     * Този метод презаписва функционалността от Price, тъй като логиката за изчисляване
     * на това каква сума пари трябва да се плати за да бъде закупен този продукт е по разлина.
     *
     * @param quantity количеството, което се закупува.
     * @return сумата пари, необходима за закупуването.
     */
    @Override
    public double calculateForQuantity(int quantity) {
        int taxQuantity = quantity / 2;

        return price * taxQuantity;
    }

    @Override
    public String toString() {

        return String.format("(2 за 1 при цена %.2f)", price);
    }
}
```

- PurchaseReceipt.java

```java
/**
 * Този клас моделира касова бележка. Той съдържа името на продукта, който е закупен,
 * цената на която е закупен, количеството което е закупено, и сумата пари платена от клиента.
 */
public class PurchaseReceipt {

    private final String productName;
    private final Price price;
    private int boughtQuantity;
    private final double paidAmount;

    /**
     * Конструктор на касова бележка.
     *
     * @param productName    името на закупения продукт.
     * @param price          цената на която е закупен продукта.
     * @param boughtQuantity количеството което е закупено.
     * @param paidAmount     платената сума от клиента.
     */
    PurchaseReceipt(String productName, Price price, int boughtQuantity, double paidAmount) {
        this.productName = productName;
        this.price = price;
        this.boughtQuantity = boughtQuantity;
        this.paidAmount = paidAmount;
    }

    @Override
    public String toString() {
        return "PurchaseReceipt{" +
                "productName='" + productName + '\'' +
                ", boughtQuantity=" + boughtQuantity +
                ", price=" + price +
                ", paidAmount=" + paidAmount +
                ", change=" + getChange() +
                '}';
    }

    /**
     * Вътрешен метод, който изчислява рестото на клиента.
     *
     * @return сумата пари, която е върната на клиента.
     */
    private double getChange() {
        return paidAmount - price.calculateForQuantity(boughtQuantity);
    }
}

```

- ProductStorage.java

```java
/**
 * Този клас репрезентира зареден продукт (инвентар) в магазина. Като се пази информация за това,
 * какво е името на продукта, на каква цена се продава и какво е наличното количество от този продукт.
 */
class ProductStorage {

    private final String name;
    private final Price price;
    private int quantity;

    /**
     * Конструктор чрез, който можем да създадем инвентар описваш цена и количество на един продукт.
     *
     * @param name     името на продукта, който бива зареден в магазина.
     * @param price    цената на продукта, която ще бъде използвана при продажба.
     * @param quantity количеството от продукта, което е заредено в магазина.
     */
    ProductStorage(String name, Price price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Този метод се опитва да издаде касова бележка, ако параметрите, които са подадени са такива, че да
     * удовлетворяват продажбата на продукта.
     *
     * @param productQuery името на продукта, който клиента иска да закупи.
     * @param amount       сумата която клиента има налична.
     * @param quantity     количеството, което клиента иска да закупи.
     * @return при покриване на критерия за продажба се връща {@link PurchaseReceipt} с детайлите за продажбата,
     * в противен случай се връща null.
     */
    PurchaseReceipt tryToSell(String productQuery, int amount, int quantity) {

        if (canBeBought(productQuery, amount, quantity)) {

            reduceQuantity(quantity);

            return new PurchaseReceipt(productQuery, price, quantity, amount);
        }

        return null;
    }

    /**
     * Този метод се опитва да увеличи количеството от даден продукт.
     * Той се използва, когато магазина иска да зареди наново продукт, който все още не е изчерпан.
     *
     * @param name     името на продукта.
     * @param price    цената на продукта.
     * @param quantity количеството което се зарежда в магазина.
     * @return true при успешно зареждане, false в противен случай.
     */
    boolean tryToIncreaseQuantity(String name, Price price, int quantity) {

        if (isForProduct(name, price)) {
            increaseQuantity(quantity);
            return true;
        }

        return false;
    }

    /**
     * Този метод проверява дали е изчерпано количеството от този продукт.
     *
     * @return true когато е изчерпано, false в противен случай.
     */
    boolean isDepleted() {
        return this.quantity == 0;
    }

    /**
     * Вътрешен метод, който проверява дали клиента иска да закупи продукт с това име, цена и количество.
     *
     * @param productQuery името на продукта, който клиента търси.
     * @param amount       сумата пари, която клиента има налична.
     * @param quantity     количеството, което иска да закупи.
     * @return true при успешно закупуване, false в противен случай.
     */
    private boolean canBeBought(String productQuery, int amount, int quantity) {

        return name.equals(productQuery)
                && this.price.canBePaid(amount, quantity);
    }

    /**
     * Вътрешен метод, който проверява дали името и цената са еднакви с тази на вече заредения продукт.
     *
     * @param name  име на продукт, който ще бъде зареждан.
     * @param price цената на продукта, която ще бъде зареждана.
     * @return true при еднакво име и цена, false в противен случай.
     */
    private boolean isForProduct(String name, Price price) {
        return this.name.equals(name)
                && this.price.equals(price);
    }

    /**
     * Този метод намалява количеството на заредения продукт.
     *
     * @param quantity количеството с което да се намали.
     */
    private void reduceQuantity(int quantity) {
        this.quantity -= quantity;
    }

    /**
     * Този метод увеличава количеството на заредения продукт.
     *
     * @param quantity количеството с което да се увеличи.
     */
    private void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }
}
```

- Shop.java

```java
/**
 * Този клас моделира магазин. Един магазин може да бъде зареждан с продукти на определен цена и определено количество
 * и също така да продава вече заредени продукти.
 */
public class Shop {

    /**
     * В този масив пазим всички вече заредени продукти.
     */
    private final ProductStorage[] inventory = new ProductStorage[1000];

    /**
     * С този метод можем да зареждам продукт с определено име, фиксирана цена и количество
     *
     * @param name     името на продукта.
     * @param price    цената на продукта.
     * @param quantity количеството на продукта.
     * @return true ако успешно е зареден продукта, false в противен случай.
     */
    public boolean add(String name, double price, int quantity) {

        return add(name, new Price(price), quantity);
    }

    /**
     * С този метод, аналогично на първия може да се зарежда даден продукт, с тази разлика че
     * е възможно да бъде използван за зареждане на продукти на промоционални цени.
     *
     * @param name     име на продукта.
     * @param price    цена на продукта.
     * @param quantity количество на продукта.
     * @return true ако успешно е зареден продукта, false в противен случай.
     */
    public boolean add(String name, Price price, int quantity) {

        for (int i = 0; i < inventory.length; i++) {

            ProductStorage currentStorage = inventory[i];

            if (currentStorage == null) {
                ProductStorage item = new ProductStorage(name, price, quantity);
                inventory[i] = item;

                return true;
            } else if (currentStorage.tryToIncreaseQuantity(name, price, quantity)) {

                return true;
            }
        }

        return false;
    }

    /**
     * С този метод може да бъде закупуван/продаван даден продукт.
     *
     * @param productQuery името на продукта, който клиента иска да закупи.
     * @param amount       цената на продукта.
     * @param quantity     количеството от продукта.
     * @return при успешно закупуване се връща {@link PurchaseReceipt} в противен случай null.
     */
    public PurchaseReceipt buy(String productQuery, int amount, int quantity) {

        for (int i = 0; i < inventory.length; i++) {
            ProductStorage item = inventory[i];

            if (item == null) {
                continue;
            }

            PurchaseReceipt receipt = item.tryToSell(productQuery, amount, quantity);

            if (item.isDepleted()) {
                inventory[i] = null; // избягваме Memory Leak
            }

            if (receipt != null) {

                return receipt;
            }
        }

        return null;
    }

    /**
     * Този метод, аналогично на предходния може да се закупува продукт с тази разлика че количеството винаги е 1.
     *
     * @param productQuery името на продукта, който клиента иска да закупи.
     * @param amount       сумата пари, която клиента има налична.
     * @@return при успешно закупуване се връща {@link PurchaseReceipt} в противен случай null.
     */
    public PurchaseReceipt buy(String productQuery, int amount) {

        return buy(productQuery, amount, 1);
    }

}
```
</p>
</details>