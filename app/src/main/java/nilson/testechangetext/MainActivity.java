package nilson.testechangetext;

import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        final EditText editText = (EditText) findViewById(R.id.editText);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            //O soft keyboard do android acessa a funçao onTextChanged tres vezes ao ser aberto,
            //na segunda vez ele zera os valores simulando a limpeza do campo.
            //A variavel "atualizando" controla quando o campo está realmente sendo limpo ou
            //quando é apenas o soft keyboard
            int atualizando=0;
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i("LNM aff", "i="+atualizando+"; start="+start+"; berore="+before+"; count="+count+" ");

                if(start>0){
                    atualizando=1;
                }

                if( atualizando>0 && s.length()>0 && start==0) {
                    atualizando=0;
                }

                if(s.length()==0 && start==0 && (atualizando==0 || before==1)) {
                    Log.i("LNM Congratulations", "Desta forma eu realmente limpei todo o meu campo de texto");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
