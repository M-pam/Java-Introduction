# Lecture 14
#java course#

## Files & Input/Output

### Files

В Java всички файлове, включително директориите са обекти. Те са част от така нареченото
IO API (application programming interface). 

Когато искаме да прочетем/създадем един file, ние трябвад да знаем пътя до този file и неговото име.

Пътищата биват два вида.

- **релативни пътища** - Това са пътища спрямо нещо от файловата система. В нашия случай релативните пътища, ще са 
спрямо *root* директроията на проекта. Пример `./java/HelloWorld.java` 

- **абсолютни пътища** - Това са пътища, които еднозначно определят къде се намира даден файл. Те започват спрямо 
*root* на операционната система. Пример `/Projects/java/HelloWorld.java`

**Важно**: Различните операционни системи репрезентират пътищата във файловата система по различен начин.  
Например *Unix* базираните системи използват **/**, като сепаратор, докато *Windows* базираните
системи използват **\\**. Когато се упоменават пътища в Java се използва **/**. 

#### java.io.File

`java.io.File` е класът от стандартната библиотека на Java, който моделира класове и директории. 
Чрез него ние можем да четем и да пишем в даден файл. Да проверяваме съдържанието на директории. 
Да създаваме нови файлове/директории, както и да изтрием съществуващи.

##### Операции с File

Използвайки конструктора на класът `File` ние можем да упоменем пътя до директорията/файла, който искаме да четем.
Като пътя до директорията/файла може да е релативен или абсолютен.

```java
File file = new File("test.txt"); // релативен път до файла test.txt

boolean testFileExists = file.exists();
boolean testIsFile = file.isFile();
boolean testIsDirectory = file.isDirectory();

System.out.println(file.getName());
System.out.printf("fileExists: %b isFile: %b isDirectory: %b%n%n", testFileExists, testIsFile, testIsDirectory);


File directory = new File("src"); // релативен път до директорията src

boolean srcFileExists = directory.exists();
boolean srcIsFile = directory.isFile();
boolean srcIsDirectory = directory.isDirectory();

System.out.println(directory.getName());
System.out.printf("fileExists: %b isFile: %b isDirectory: %b%n%n", srcFileExists, srcIsFile, srcIsDirectory);

File[] files = directory.listFiles();

if (files != null) {
    System.out.printf("Number of files inside '%s' is %d%n", directory.getName(), files.length);
}
```

> ℹ️ За повече информация отновно, това какво може да се прави с `File` класът 
вижте това [youtube видео](https://www.youtube.com/watch?v=o9F73FU2vzs).

### I/O

###### Streams

Input и Output са механизми за четене и писане. Те намират приложение навсякъде където е необходимо да се трансферират
данни. Било то комуникация м/у два сървъра до трансфериране на данни от и на файловата система.

Трансферирането става чрез четене или писане на поток от данни. Този поток се нарича `Stream`. Когато четем данни,
ние използваме поток за входни данни или по-точно `InputStream`. Когато пишем данни ние ползваме поток за изходни данни
или `OutputStream`.

> Представете си радио сигнала, той е поток от входни данни за радио станциите 📻.

Един пример за писане на данни е `System.out.println()`, където `System.out` е вид `OutputStream`.

![input_vs_output_stream](../../../assets/14-lecture/input_vs_output_stream.png)

Обикновенно данните, които се трансферират в stream-овете се конвертират до байтове. Тези данни са подредени т.е ако
изпратим числата 1, 2 и 3 ще ги получим в същия ред. Веднъж влезли данните в потока, те не могат да бъдат пренареждани.
Четенето на данните винаги е последователно, не може да се изчетат байтове на случаен принцип. 
При прочитането на данните от потока, те се премахват от него и не могат да бъдат прочетени втори път.

###### Data Streams

Съществува I/O Stream, който е способен да записва типовете данни, независимо вида на файловата система. Така ние можем да записваме/четем
примитивни типове като `int`, `char`, `boolean` и тнт. Това е така наречения `DataInputStream` и `DataOutputStream`.

![data_input_vs_data_output_stream](../../../assets/14-lecture/data_input_vs_data_output_stream.png)

###### Buffered Streams

Писането и четенето на данни byte по byte може да създаде забавяне. Всяко едно писане/четене изисква програмата да се 
обърне към операционната система с заявка за четене/писане, която от своя страна трябва да локализира в паметта нещото,
което ще се чете/пише.  
За да се намали бройката на тези операции, може да се използват така наречените `BufferedInputStream` за четене и съответно
`BufferedOutputStream` за писане. Този вид потоци използват вътрешен буфер, който намалява обръщенията до операционната 
система и вместо това ги буферира, като само в определени случаи се изпълнява обръщение към операционната система.
Например, когато се напълни буфера.

![buffered_writer_stream](../../../assets/14-lecture/buffered_writer_stream.jpeg)

> ℹ️ За повече информация отновно **I/O** вижте това [youtube видео](https://www.youtube.com/watch?v=D_WDuwnaobg&t=558s).

#### File I/O

Четенето и писането на файлове се реализира с помощта на **Input** и **Output** **Stream**.

Няколко неща, които трябва да знаем, когато боравим със файлове:

- За прочитане на цял файл се чете от `InputStream` докато не бъде достигнат краят на файла. Края на файла се нарича 
**EOF (end of file)** и се репрезентира, като byte със стойност -1.

- Когато четем/пишем файл се установява връзка (stream) със този файл. При приключване на операцията този stream 
**ТРЯБВА ДА БЪДЕ ЗАТВОРЕН**.

![stream_hierarchy](../../../assets/14-lecture/stream_hierarchy.jpg)

- Пример за четене на файл byte по byte

```java
File file = new File("test.txt");

FileInputStream fileStream = new FileInputStream(file);

int readByte = 0;
while (readByte != -1) {
    readByte = fileStream.read();
}

fileStream.close();
```

- Пример за писане на byte по byte

```java
File file = new File("test.txt");

FileOutputStream fileStream = new FileOutputStream(file);

fileStream.write('t');
fileStream.write('e');
fileStream.write('s');
fileStream.write('t');

fileStream.flush();
fileStream.close();
```

## Tasks

### Task 1

Създайте програма, която проверява съдържанието на директорията `iotest`.
Ако тази директория несъществува да се създаде от програмата.
След като бъде създадена от програмата ръчно създайте файловете `a.txt`, `b.txt` и `c.txt` в тази директория.
Да се принтират имената на файловете в директорията.

- `iotest` се намира релативно в текущия проект

> Използвайте `File.mkdir()` за създаване на директория. 

<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

```java
import java.io.File;

public class Task1 {

    public static void main(String[] args) {
        File file = new File("iotest");

        if (!file.exists()) {
            file.mkdir();
        }

        for (String name : file.list()) {
            System.out.println(name);
        }
    }
}
```

</p>
</details>

### Task 2

Създайте директория намираща се в `C:\test\iotest` чрез *Windows Explorer*. 
Създайте 3 файла с имена `foo.txt`, `bar.txt`, `zar.txt`, `Zab.txt`.

Създайте програма, която изтрива файловете започващи със `z` без значение малки/големи букви (case insensitive).

> Използвайте `File.delete()` за да изтриете файла, `String.startsWith("z")` за да проверите дали името започва със `z`.

### Task 3

Напишете програма, която сравнява две снимки, дали са еднакви.

> Използвайте `FileInputStream` и сравнявайте byte по byte снимките.

### Task 4

Напишете програма, която взема от потребителя входни данни и ги записва във файла `exo.txt`.
Програмата изисква входни данни, от потребителя, докато не бъде въведена думата `stop`.

> Използвайте `PrintWriter.println()` за да записвате всяка дума на нов ред.

<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

```java
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriteDemo {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        List<String> data = new ArrayList<>();
        while (true) {

            System.out.print("Въведете текст: ");
            String input = scanner.nextLine();

            if ("stop".equalsIgnoreCase(input)) {
                break;
            }

            data.add(input);
        }

        File createdFile = createFile("echo.txt");

        PrintWriter writer = new PrintWriter(createdFile);

        for (String eachData : data) {
            writer.println(eachData);
        }

        writer.flush();
        writer.close();

        System.out.println("Проверете съдържанеието на echo.txt");
    }

    private static File createFile(String name) {
        File myFile = new File(name);

        try {
            myFile.createNewFile();
            return myFile;
        } catch (IOException e) {
            throw new RuntimeException("There was an error creating the file.", e);
        }
    }
}
```

</p>
</details>
