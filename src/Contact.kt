class ContactManager(name: String? = "Unknown name", phoneNumber: String? = "-1"){
    var name = name?.takeUnless { it.isBlank() }?:"Unknown name"
    var phoneNumber = phoneNumber?.takeIf { it.toIntOrNull() != null } ?: "-1"

    fun addContact(): String {
        return when{
            name in ContactStorage.contacts -> "Контакт с таким именем уже существует, его номер ${ContactStorage.contacts[name]}"
            phoneNumber in ContactStorage.contacts.values -> "Контакт с таким номером уже существует, его имя ${ContactStorage.contacts.filterValues { it == phoneNumber }.keys.joinToString("")}"
            else -> {
                ContactStorage.contacts[name] = phoneNumber
                "Контакт успешно добавлен"
            }
        }
    }

    fun deleteContact(): String {
        return if (ContactStorage.contacts.remove(name) != null) {
            "Контакт успешно удален"
        } else {
            "Такого контакта нет"
        }
    }

    fun watchAllContacts():String{
        if (ContactStorage.contacts.isEmpty()) return "Контактов нет"
        var incrementer = 0
        println("Все контакты:")
        ContactStorage.contacts.forEach{
            println("${++incrementer}. $it")
        }
        return "Конец"
    }

    override fun toString() = "$name, $phoneNumber"
}