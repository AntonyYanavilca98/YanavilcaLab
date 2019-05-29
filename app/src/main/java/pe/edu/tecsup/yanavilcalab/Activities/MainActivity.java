package pe.edu.tecsup.yanavilcalab.Activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import pe.edu.tecsup.yanavilcalab.Adapters.NotesAdapter;
import pe.edu.tecsup.yanavilcalab.Modelos.Note;
import pe.edu.tecsup.yanavilcalab.R;
import pe.edu.tecsup.yanavilcalab.Repositories.NoteRepository;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton add;
    private static final int REGISTER_FORM_REQUEST = 100;
    private RecyclerView notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.add_note_a);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNote();
            }
        });
        notesList = findViewById(R.id.notas_lista);
        notesList.setLayoutManager(new LinearLayoutManager(this));
        List<Note> notas = NoteRepository.listar();
        notesList.setAdapter(new NotesAdapter(notas));
    }
    //Yendo a AddNoteActivity
    public void addNote() {
        startActivityForResult(new Intent(this, AddNoteActivity.class), REGISTER_FORM_REQUEST);
    }

    // return from AddNoteActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // refresh data
        NotesAdapter adapter = (NotesAdapter)notesList.getAdapter();

        //Obteniemos del repository la lista de usuarios actualizada.
        List<Note> notas = NoteRepository.listar();
        adapter.setNotas(notas);
        adapter.notifyDataSetChanged();

    }
}
