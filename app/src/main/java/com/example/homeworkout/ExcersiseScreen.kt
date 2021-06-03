package com.example.homeworkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.homeworkout.databinding.ActivityExcersiseScreenBinding
import java.util.*

class ExcersiseScreen : AppCompatActivity(),TextToSpeech.OnInitListener {
    private lateinit var binding: ActivityExcersiseScreenBinding
    private var restTimer:CountDownTimer?=null
    private var restProgress=0
    val arr : MutableList<String> = mutableListOf()
    private var textToSpeech:TextToSpeech?=null

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityExcersiseScreenBinding.inflate(layoutInflater)
            val view = binding.root
            setContentView(view)
            setSupportActionBar(binding.excersisePageToolBar)
            val actionBar=supportActionBar
            if(actionBar!=null)
            {
                actionBar.setDisplayHomeAsUpEnabled(true)
            }
            binding.excersisePageToolBar.setNavigationOnClickListener {


               onBackPressed()
            }
        textToSpeech= TextToSpeech(this,this)
        arr.add(0,"Jumping Jacks")
        arr.add(1,"Abdominal Crunch")
        arr.add(2,"High Knees Running In Place")
        arr.add(3,"Lunges")
        arr.add(4,"Plank")
        arr.add(5,"Push Up")
        arr.add(6,"Push Up And Rotation")
        arr.add(7,"Side Plank")
        arr.add(8,"Squat")
        arr.add(9,"Step Up Onto Chair")
        arr.add(10,"Triceps dip on chair")
        arr.add(11,"Wall sit")


                setupRestView(0)


    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        //set title for alert dialog
        builder.setTitle("Exit?")
        //set message for alert dialog
        builder.setMessage("Are You Sure You Want To Exit?")


        //performing positive action
        builder.setPositiveButton("Yes"){dialogInterface, which ->
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        builder.setNeutralButton("Cancel"){dialogInterface , which ->

        }
        val alertDialog: AlertDialog = builder.create()
        // Set other dialog properties
        alertDialog.setCancelable(false)
        alertDialog.show()

    }
    override fun onDestroy() {
        if(restTimer!=null)
        {
            restTimer!!.cancel()
            restProgress=0
        }
        if(textToSpeech!=null)
        {
            textToSpeech!!.stop()
            textToSpeech!!.shutdown()
        }

        super.onDestroy()

    }

    private fun setupRestView(i:Int)
    {
        if(i==0)
        {

            speak("Get Ready For "+arr[i])
            binding.ExcerciseName.text=arr[i]
        }
        else if(i==1)
        {
            speak("Get Ready For "+arr[i])
            binding.b1.setBackgroundResource(R.drawable.count)
            binding.b2.setBackgroundResource(R.drawable.roundbtnselected)

            binding.ExcerciseName.text=arr[i]

        }
        else if(i==2)
        {
            speak("Get Ready For "+arr[i])
            binding.b2.setBackgroundResource(R.drawable.count)
            binding.b3.setBackgroundResource(R.drawable.roundbtnselected)

            binding.ExcerciseName.text=arr[i]
        }
        else if(i==3)
        {
            speak("Get Ready For "+arr[i])
            binding.b3.setBackgroundResource(R.drawable.count)
            binding.b4.setBackgroundResource(R.drawable.roundbtnselected)

            binding.ExcerciseName.text=arr[i]
        }
        else if(i==4)
        {
            speak("Get Ready For "+arr[i])
            binding.b4.setBackgroundResource(R.drawable.count)
            binding.b5.setBackgroundResource(R.drawable.roundbtnselected)

            binding.ExcerciseName.text=arr[i]
        }else if(i==5)
        {
            speak("Get Ready For "+arr[i])
            binding.b5.setBackgroundResource(R.drawable.count)
            binding.b6.setBackgroundResource(R.drawable.roundbtnselected)

            binding.ExcerciseName.text=arr[i]
        }else if(i==6)
        {
            speak("Get Ready For "+arr[i])
            binding.b6.setBackgroundResource(R.drawable.count)
            binding.b7.setBackgroundResource(R.drawable.roundbtnselected)

            binding.ExcerciseName.text=arr[i]
        }else if(i==7)
        {
            speak("Get Ready For "+arr[i])
            binding.b7.setBackgroundResource(R.drawable.count)
            binding.b8.setBackgroundResource(R.drawable.roundbtnselected)

            binding.ExcerciseName.text=arr[i]
        }else if(i==8)
        {
            speak("Get Ready For "+arr[i])
            binding.b8.setBackgroundResource(R.drawable.count)
            binding.b9.setBackgroundResource(R.drawable.roundbtnselected)

            binding.ExcerciseName.text=arr[i]
        }else if(i==9)
        {
            speak("Get Ready For "+arr[i])
            binding.b9.setBackgroundResource(R.drawable.count)
            binding.b10.setBackgroundResource(R.drawable.roundbtnselected)

            binding.ExcerciseName.text=arr[i]
        }
        else if(i==10)
        {
            speak("Get Ready For "+arr[i])
            binding.b10.setBackgroundResource(R.drawable.count)
            binding.b11.setBackgroundResource(R.drawable.roundbtnselected)

            binding.ExcerciseName.text=arr[i]
        }
        else if(i==11)
        {
            speak("Get Ready For "+arr[i])
            binding.b11.setBackgroundResource(R.drawable.count)
            binding.b12.setBackgroundResource(R.drawable.roundbtnselected)

            binding.ExcerciseName.text=arr[i]
        }
        else if(i==12)
        {
            val intent= Intent(this,CongoScreen::class.java)
            startActivity(intent)
        }
        if(restTimer!=null)
        {
            restTimer!!.cancel()
            restProgress=0
        }
        setRestProgressBar(i)
    }
    private fun setRestProgressBar(i:Int)
    {



        restTimer=object:CountDownTimer(10000,1000)
        {
            override fun onTick(millisUntilFinished: Long) {

                binding.timer.text=(10-restProgress).toString()
                restProgress++


            }

            override fun onFinish() {

                   binding.llintital.visibility= View.GONE
                    binding.llexecercise.visibility=View.VISIBLE
                setupExcerciseView(i)



            }
        }.start()
    }

    private fun setupExcercises(i:Int)
    {
        if(i==0)
        {
            speak(arr[i])
            binding.excerciseImg.setImageResource(R.drawable.ic_jumping_jacks)
            binding.excersiseName.text=arr[i]
        }
        else if(i==1)
        {
            speak(arr[i])
            binding.excerciseImg.setImageResource(R.drawable.ic_abdominal_crunch)
            binding.excersiseName.text=arr[i]

        }
        else if(i==2)
        {
            speak(arr[i])
            binding.excerciseImg.setImageResource(R.drawable.ic_high_knees_running_in_place)
            binding.excersiseName.text=arr[i]
        }
        else if(i==3)
        {
            speak(arr[i])
            binding.excerciseImg.setImageResource(R.drawable.ic_lunge)
            binding.excersiseName.text=arr[i]
        }
        else if(i==4)
        {
            speak(arr[i])
            binding.excerciseImg.setImageResource(R.drawable.ic_plank)
            binding.excersiseName.text=arr[i]
        }else if(i==5)
        {
            speak(arr[i])
            binding.excerciseImg.setImageResource(R.drawable.ic_push_up)
            binding.excersiseName.text=arr[i]
        }else if(i==6)
        {
            speak(arr[i])
            binding.excerciseImg.setImageResource(R.drawable.ic_push_up_and_rotation)
            binding.excersiseName.text=arr[i]
        }else if(i==7)
        {
            speak(arr[i])
            binding.excerciseImg.setImageResource(R.drawable.ic_side_plank)
            binding.excersiseName.text=arr[i]
        }else if(i==8)
        {
            speak(arr[i])
            binding.excerciseImg.setImageResource(R.drawable.ic_squat)
            binding.excersiseName.text=arr[i]
        }else if(i==9)
        {
            speak(arr[i])
            binding.excerciseImg.setImageResource(R.drawable.ic_step_up_onto_chair)
            binding.excersiseName.text=arr[i]
        }
        else if(i==10)
        {
            speak(arr[i])
            binding.excerciseImg.setImageResource(R.drawable.ic_triceps_dip_on_chair)
            binding.excersiseName.text=arr[i]
        }
        else if(i==11)
        {
            speak(arr[i])
            binding.excerciseImg.setImageResource(R.drawable.ic_wall_sit)
            binding.excersiseName.text=arr[i]
        }








        restTimer=object :CountDownTimer(30000,1000)
        {
            override fun onTick(millisUntilFinished: Long) {
                binding.timerToDoExcercise.text=(30-restProgress).toString()
                restProgress++
            }

            override fun onFinish() {
                binding.llintital.visibility= View.VISIBLE
                binding.llexecercise.visibility=View.GONE
                setupRestView(i+1)
            }

        }.start()
    }

    private fun setupExcerciseView(i: Int)
    {


        if(restTimer!=null)
        {
            restTimer!!.cancel()
            restProgress=0
        }
        setupExcercises(i)
    }

    override fun onInit(status: Int) {
        if(status==TextToSpeech.SUCCESS)
        {
            val result=textToSpeech!!.setLanguage(Locale.UK)
            if(result==TextToSpeech.LANG_MISSING_DATA||result==TextToSpeech.LANG_NOT_SUPPORTED)
            {
                Log.e("tts","Language Specified Is not Available")
            }
            else
            {
                Log.e("tts","Error")
            }
        }

    }
    private fun speak(text:String)
    {
        textToSpeech!!.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")
    }

}