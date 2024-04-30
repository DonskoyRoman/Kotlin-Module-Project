import java.util.*


class NoteViewer(val note: Note, val scanner: Scanner) {
    fun show() {
        println("\nЗаметка: ${note.title}")
        println(note.content)
    }
}
