package th.ac.lannapoly.app_lannapoly

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class MainActivity : AppCompatActivity(),
        HOMEfragment.OnFragmentInteractionListener,
        Contactfragment.OnFragmentInteractionListener
{
    var  homeFragment : HOMEfragment? = null
    var  contactfragment : Contactfragment? = null

    override fun onFragmentInteraction(uri: Uri) {

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                if(homeFragment == null){
                homeFragment = HOMEfragment()
                }
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame_layout, homeFragment)
//                transaction.addToBackStack(null)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
                

            }
            R.id.navigation_dashboard -> {
                //message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                //message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_menu -> {
                //message.setText(R.string.title_menu)
                if(contactfragment == null) {
                    contactfragment = Contactfragment()
                }
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame_layout, contactfragment)
                transaction.addToBackStack(null)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        homeFragment = HOMEfragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, homeFragment)
        //transaction.addToBackStack(null)
        transaction.commit()



    }
}
