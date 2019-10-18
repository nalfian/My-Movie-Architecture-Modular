package id.localrental.architecturemodular

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.nalfian.base.util.Actions

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Actions.openUpcoming(this))
    }
}
