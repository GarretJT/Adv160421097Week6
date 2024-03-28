package com.example.adv160421097week6.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.adv160421097week6.databinding.CarListItemBinding
import com.example.adv160421097week6.model.Car

class CarListAdapter(private val carList: ArrayList<Car>) :
    RecyclerView.Adapter<CarListAdapter.CarViewHolder>() {

    class CarViewHolder(val binding: CarListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding = CarListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = carList[position]
        holder.binding.textModel.text = car.model
        holder.binding.textYear.text = car.year

        holder.binding.root.setOnClickListener {
        }
    }

    override fun getItemCount(): Int {
        return carList.size
    }

    fun updateCarList(newCarList: List<Car>) {
        carList.clear()
        carList.addAll(newCarList)
        notifyDataSetChanged()
    }
}
