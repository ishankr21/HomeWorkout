package com.example.homeworkout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homeworkout.databinding.FragmentBMIkgBinding
import com.example.homeworkout.databinding.FragmentBMIpoundBinding


class BMIpoundFragment : Fragment() {


    private var _binding: FragmentBMIpoundBinding?=null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBMIpoundBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.btnCalBMIpd.setOnClickListener {
            calculateBMI()
        }
        return view
    }

    private fun calculateBMI() {
        val weight=binding.edBMIwtpd.text.toString().toDouble()
        var height=binding.edBMIhtpd.text.toString().toDouble()

        height=height*height
        var bmi=(weight/height)*703
        bmi= String.format("%.2f", bmi).toDouble()
        binding.txtBMIpd.text=bmi.toString()
        if(bmi>25)
        {
            binding.txtconditionpd.text="Over Weight";
            binding.txtmessagepd.text="Excercise More!!"
        }
        else if(bmi<14.5)
        {
            binding.txtconditionpd.text="Under Weight";
            binding.txtmessagepd.text="Please Improve your diet!!"
        }
        else
        {
            binding.txtconditionpd.text="Normal";
            binding.txtmessagepd.text="Congratulation! You Are In Good Shape!"
        }
        binding.LLshowBMIpd.visibility=View.VISIBLE

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}