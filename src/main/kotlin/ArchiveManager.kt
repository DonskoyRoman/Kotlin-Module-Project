import java.util.Scanner

class ArchiveManager(val scanner: Scanner) {
    val archives = mutableListOf<Archive>()

    fun createArchive(): Archive {
        var name = ""
        while (name.isBlank()) {
            print("Введите название архива: ")
            name = scanner.nextLine()
            if (name.isBlank()) {
                println("Поле пустое, попробуйте еще раз.")
            }
        }
        val newArchive = Archive(name)
        archives.add(newArchive)
        println("Архив '$name' создан.")
        return newArchive
    }

    fun viewArchive(archive: Archive) {
        println("\nАрхив '${archive.name}':")
        archive.notes.forEachIndexed { i, note -> println("${i + 1}. ${note.title}") }
        val menuItemNumber = archive.notes.size + 1
        println("0. Создать заметку")
        println("$menuItemNumber. Выйти в главное меню")
        print("Введите номер: ")

        when (val input = scanner.nextLine()) {
            "0" -> createNoteInArchive(archive)
            "$menuItemNumber" -> return
            else -> {
                val noteIndex = input.toIntOrNull()?.minus(1)
                if (noteIndex != null && noteIndex in archive.notes.indices) {
                    val selectedNote = archive.notes[noteIndex]
                    NoteViewer(selectedNote, scanner).show()
                } else {
                    println("Неверный ввод, попробуйте снова.")
                }
            }
        }
    }

    private fun createNoteInArchive(archive: Archive) {
        val noteManager = NoteManager(scanner)
        val note = noteManager.createNote()
        archive.notes.add(note)
        println("Заметка успешно добавлена в архив '${archive.name}'.")
    }
}