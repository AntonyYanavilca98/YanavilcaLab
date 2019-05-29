package pe.edu.tecsup.yanavilcalab.Repositories;

import com.orm.SugarRecord;

import java.util.List;

import pe.edu.tecsup.yanavilcalab.Modelos.Note;

public class NoteRepository {

    public static void create(String fecha, String titulo, String descripcion) {

        Note note = new Note();
        note.setDate(fecha);
        note.setTitle(titulo);
        note.setDescription(descripcion);

        SugarRecord.save(note);
    }

    public static List<Note> listar(){

        return SugarRecord.listAll(Note.class);
    }
}
