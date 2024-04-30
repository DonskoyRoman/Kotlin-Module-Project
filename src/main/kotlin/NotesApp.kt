import java.util.Scanner

class NotesApp(val scanner: Scanner = Scanner(System.`in`)) {
    val archiveManager = ArchiveManager(scanner)

    fun start() {
        while (true) {
            println("\nВыбор архива:")
            println("0. Создать архив")
            archiveManager.archives.forEachIndexed { index, archive -> println("${index + 1}. ${archive.name}") }
            println("${archiveManager.archives.size + 1}. Выход")
            print("Введите номер: ")

            when (val input = scanner.nextLine()) {
                "0" -> archiveManager.createArchive()
                "${archiveManager.archives.size + 1}" -> return
                else -> {
                    val index = input.toIntOrNull()?.minus(1)
                    if (index != null && index in archiveManager.archives.indices) {
                        val selectedArchive = archiveManager.archives[index]
                        archiveManager.viewArchive(selectedArchive)
                    } else {
                        println("Неверный ввод, попробуйте снова.")
                    }
                }
            }
        }
    }
}