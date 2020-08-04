# 👀 Homework Solutions Lecture 9
#java course#

## Inheritance (Наследяване) 🏛️

### Task 1

Създайте програма, която симулира работата на болница. 🏥  
В една болница има няколко участника:
- Доктори (Doctor)
- Пациенти (Patient)

И докторите и пациентите се характеризират с:
- име (name)
- възраст (age)
- дали е мъж или жена  (isFemale)

Един пациент се характеризира с:
- Диагноза (diagnose)
    - примерна диагноза може да е `кардиолог` (това означава че трябва да посети кардиолог)    
- Способността да му се поставя диагноза (setDiagnose)
- Способността да му се премахва диагноза (removeDiagnose)

Докторите се характеризират с:
- способността да лекуват пациенти (heal) (просто премахват диагнозата на пациента)

Докторите се делят на различни под типове:
- Кардиолог (Cardiologist)
    - лекува само диагнози тип `кардиолог`
- Дерматолог (Dermatologist)
    - лекува само диагнози тип `дерматолог`
- Педиатър (Pediatrician)
    - лекува само пациенти на възраст под 18 години


Болницата е това което навръзва докторите с пациентите. Тя се характеризира с:
- множество доктори
- способността да се добавя доктор
- способността да се лекува пациент
    - за целта болницата намира лекаря, който може да излекува пациента и го лекува
    
###### Примерна йерархия на програмата

- class Person
    - class Patient
        - class MalePatient 
        - class FemalePatient
    - class Doctor
        - class Cardiologist
        - class Dermatologist
        - class Pediatrician

<details><summary><b>Solution</b> 👀</summary> 
<p>

- Person.java
```java
/**
 * Клас който представлява човек.
 * Този клас съдържа общите свойства м/у пациенти и лекари.
 */
class Person {

    final String name;
    final int age;
    final boolean isFemale;

    Person(String name, int age, boolean isFemale) {
        this.name = name;
        this.age = age;
        this.isFemale = isFemale;
    }

    @Override
    public String toString() {
        return "Person{ " + name + " " + age + " " + isFemale + " }";
    }
}
```

- Patient.java

```java
/**
 * Клас пациент, който наследява {@link Person}.
 * Така пациента има достъп до името, годините и пола на човека.
 * <p>
 * Този клас надгражда с това че добавя диагноза и няколко метода, които оперират с диагнозата.
 */
class Patient extends Person {

    private String diagnose;

    Patient(String name, int age, boolean isFemale) {
        super(name, age, isFemale);
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void removeDiagnose() {
        diagnose = null;
    }
}
```

- MalePatient.java

```java
/**
 * Клас МъжкиПациент, който наследява {@link Patient}.
 * Единственото, което прави този клас е да създава нов конструктор с един параметър по-малко и подава false,
 * като параметър за пол на super конструктора.
 */
class MalePatient extends Patient {

    MalePatient(String name, int age) {
        super(name, age, false);
    }
}
```

- FemalePatient.java

```java
/**
 * Клас ЖенскиПациент, който наследява {@link Patient}.
 * Единственото, което прави този клас е да създава нов конструктор с един параметър по-малко и подава true,
 * като параметър за пол на super конструктора.
 */
class FemalePatient extends Patient {

    FemalePatient(String name, int age) {
        super(name, age, true);
    }
}
```

- Doctor.java

```java
/**
 * Абстрактен клас доктор. Този клас наследява {@link Person}.
 * Класът дефинира метода heal за лекуване на пациенти, както и абстрактен метод canHeal, който ще бъде
 * дефиниран от всеки вид доктор. Този клас понеже е абстрактен не може да бъде инстанциран директно.
 * Необходимо е да има наследник на този клас за да може да бъде създаден.
 */
abstract class Doctor extends Person {

    public Doctor(String name, int age, boolean isFemale) {
        super(name, age, isFemale);
    }

    /**
     * Метод който лекува пациента, единствено ако пациента може да бъде излекуван от текущия лекар.
     * Този метод използва абстрактния метод {@link Doctor#canHeal(Patient)}
     *
     * @param patient пациента, който ще бъде излекуван.
     * @return true ако пациента е успешно излекуван, false в противен случай.
     */
    public boolean heal(Patient patient) {

        if (canHeal(patient)) {
            patient.removeDiagnose();
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Doctor{ " + name + " " + age + " }";
    }

    /**
     * Абстрактен метод, който ще пъде задължителен за всеки наследник на този клас.
     * Наследникът е длъжен да имплементира този метод.
     *
     * @param patient пациента, който ще бъде лекуван.
     * @return true ако пациента може да бъде излекувам от този лекар, false в противен случай.
     */
    public abstract boolean canHeal(Patient patient);
}
```

- Cardiologist.java

```java
/**
 * Клас който представлява специализиран доктор кардиолог.
 * <p>
 * Този тип доктор мое да лекува пациенти само с диагноза "кардиолог".
 */
class Cardiologist extends Doctor {

    public Cardiologist(String name, int age, boolean isFemale) {
        super(name, age, isFemale);
    }

    @Override // класът Cardiologist имплементира абстрактния метод canHeal дефиниран в Doctor класът
    public boolean canHeal(Patient patient) {
        return "кардиолог".equals(patient.getDiagnose());
    }
}
```

- Dermatologist.java

```java
/**
 * Клас който представлява специализиран доктор дерматолог.
 * <p>
 * Този тип доктор мое да лекува пациенти само с диагноза "дерматолог".
 */
class Dermatologist extends Doctor {

    public Dermatologist(String name, int age, boolean isFemale) {
        super(name, age, isFemale);
    }

    @Override // класът Dermatologist имплементира абстрактния метод canHeal дефиниран в Doctor класът
    public boolean canHeal(Patient patient) {
        return "дерматолог".equals(patient.getDiagnose());
    }
}
```

- Pediatrician.java

```java
/**
 * Клас който представлява специализиран доктор педиатър.
 * <p>
 * Този тип доктор мое да лекува пациенти само под 18 години".
 */
class Pediatrician extends Doctor {

    public Pediatrician(String name, int age, boolean isFemale) {
        super(name, age, isFemale);
    }

    @Override // класът Pediatrician имплементира абстрактния метод canHeal дефиниран в Doctor класът
    public boolean canHeal(Patient patient) {
        return patient.age < 18;
    }
}
```

- Hospital.java

```java
/**
 * Репрезентация на болница, която свързва лекарите с пациентите.
 */
class Hospital {

    private Doctor[] doctors = new Doctor[10];

    /**
     * Метод добавяш лекари в болницата.
     *
     * @param doctor лекарят който ще бъде добавен в болницата.
     */
    public void addDoctor(Doctor doctor) {

        for (int i = 0; i < doctors.length; i++) {

            if (doctors[i] == null) {
                doctors[i] = doctor;
                return;
            }
        }
    }

    /**
     * Метод приемащ пациент, който да бъде излекуван.
     * Този метод се грижи за това да намери доктор от съществуващите в болницата
     * и да го използва за да излекува пациента
     *
     * @param patient пациента който трябва да бъде излекуван.
     */
    public void heal(Patient patient) {

        for (Doctor doctor : doctors) {
            if (doctor == null) {
                continue;
            }

            boolean healed = doctor.heal(patient);

            if (healed) {
                System.out.printf("Доктор %s излекува пациент %s\n", doctor, patient);
                return;
            }
        }

        System.out.printf("Не беше намерен лекар, който да излекува %s\n", patient);

    }
}
```    

- HospitalDemo.java

```java
public class HospitalDemo {

    public static void main(String[] args) {

        // Създаване на различните видове доктори
        Cardiologist cardiolog = new Cardiologist("Ivan", 40, false);
        Dermatologist dermatholog = new Dermatologist("Joana", 40, true);
        Pediatrician pediater = new Pediatrician("Georgi", 40, false);

        // Създаване на болницата
        Hospital hospital = new Hospital();

        // Добавяне на докторите в болницата
        hospital.addDoctor(cardiolog);
        hospital.addDoctor(dermatholog);
        hospital.addDoctor(pediater);

        // Създаване на малолетен пациент
        Patient goshko = new MalePatient("Goshko", 15);

        // Създаване на пациент с диагноза 'дерматолог'
        Patient lyudmila = new FemalePatient("Lyudmila", 30);
        lyudmila.setDiagnose("дерматолог");

        // Създаване на пациент с диагноза 'кардиолог'
        Patient parvan = new MalePatient("Parvan", 30);
        parvan.setDiagnose("кардиолог");

        // Излекуване на пациентите
        hospital.heal(goshko);
        hospital.heal(lyudmila);
        hospital.heal(parvan);
    }
}
```
</p>
</details>
