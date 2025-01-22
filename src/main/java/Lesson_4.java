public class Lesson_4 {

    public static void main(String args[]){

        System.out.println("Первое и второе задание:\n");
        Employee[] personArray = new Employee[5];
        personArray[0] = new Employee("Иванова Анастасия Анатольевна","администратор", "ivanova@yandex.ru", "89172273116", 20000, 26);
        personArray[1] = new Employee("Иванов Василий Владимирович","оператор", "ivanov@yandex.ru", "89172273115", 25000, 29);
        personArray[2] = new Employee("Белкин Роман Антонович","Директор склада", "belkin@yandex.ru", "89172273111", 150000, 47);
        personArray[3] = new Employee("Белкина Юлия Андреевна","заместитель директора по финансам", "belkina@yandex.ru", "89172273112", 100000, 43);
        personArray[4] = new Employee("Белкин Антон Романович","Руководитель отдела безопасности", "belkinsave@yandex.ru", "89172273113", 85000, 20);
        personArray[1].printPerson();
        personArray[3].printPerson();

        System.out.println("Третье задание:\n");
        Park.Attraction carousel = new Park().new Attraction("Карусель","11:00 - 22:00", "100 рублей");
        carousel.printInfo();
        Park.Attraction ferrisWheel = new Park().new Attraction("Колесо обозрения","11:00 - 21:00", "200 рублей");
        ferrisWheel.printInfo();
        Park.Attraction phoenix = new Park().new Attraction("Феникс","11:00 - 18:00", "500 рублей");
        phoenix.printInfo();
    }

    public static class Employee{

        private String fullName;
        private String jobTitle;
        private String email;
        private String phoneNumber;
        private int salary;
        private int age;

        public Employee(String fullName, String jobTitle, String email, String phoneNumber, int salary, int age){
            this.fullName = fullName;
            this.jobTitle = jobTitle;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.salary = salary;
            this.age = age;
        }

        public void printPerson(){
            System.out.println("Имя сотрудника: "+fullName+"\nДолжность: "+jobTitle+"\nЭлектронная почта: "+email+"\nНомер телефона: "+phoneNumber+"\nЗарплата: "+salary+"\nВозраст: "+age+"\n");
        }
    }

    public static class Park{

        public class Attraction{

            private String time;
            private String price;
            private String name;

            public Attraction(String name,String time,String price){
                this.time = time;
                this.price = price;
                this.name = name;
            }

            public void printInfo(){
                System.out.println("Название: "+name+"\nВремя работы: "+time+"\nСтоимость аттракциона: "+price+"\n");
            }
        }
    }
}
