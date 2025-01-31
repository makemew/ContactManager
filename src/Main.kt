fun showMenu() {
    println()
    println("Меню:")
    println("1. Добавить контакт")
    println("2. Удалить контакт")
    println("3. Посмотреть все контакты")
    println("4. Выйти")
    print("Выберите действие (1-4): ")
}

fun main() {
    while(true){
        showMenu()
        when (readln()){
            "1"->{
                print("Введите имя контакта: ")
                val name = readln()
                print("Введите номер контакта: ")
                val phoneNumber = readln()
                val contactManager = ContactManager(name, phoneNumber)
                println(contactManager.addContact())
            } "2"->{
                print("Введите имя контакта: ")
                val name = readln()
                val contactManager = ContactManager(name)
                println(contactManager.deleteContact())
            } "3" -> {
                val contactManager = ContactManager()
                println(contactManager.watchAllContacts())
            } "4" -> {
                println("Выход из программы...")
                return
            }else -> println("Некорректный ввод. Пожалуйста, введите число от 1 до 4")
        }
    }
}