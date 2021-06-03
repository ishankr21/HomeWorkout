package com.example.homeworkout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homeworkout.databinding.ActivityBmiactivityBinding
import com.example.homeworkout.databinding.FragmentBMIkgBinding


class BMIkgFragment : Fragment() {

    private var _binding: FragmentBMIkgBinding?=null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBMIkgBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.btnCalBMI.setOnClickListener {
            calculateBMI()
        }
        return view
    }

    private fun calculateBMI() {
        val weight=binding.edBMIwt.text.toString().toDouble()
        var height=binding.edBMIht.text.toString().toDouble()
        height=height/100
        height=height*height
        var bmi=weight/height
        bmi= String.format("%.2f", bmi).toDouble()
        binding.txtBMI.text=bmi.toString()
        if(bmi>25)
        {
            binding.txtcondition.text="Over Weight";
            binding.txtmessage.text="Excercise More!!"
        }
        else if(bmi<14.5)
        {
            binding.txtcondition.text="Under Weight";
            binding.txtmessage.text="Please Improve your diet!!"
        }
        else
        {
            binding.txtcondition.text="Normal";
            binding.txtmessage.text="Congratulation! You Are In Good Shape!"
        }
        binding.LLshowBMI.visibility=View.VISIBLE

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}