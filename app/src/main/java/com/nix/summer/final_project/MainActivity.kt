package com.nix.summer.final_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val model = Model()
    private val controller = Controller(model)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        controller.attachView(this)
        controller.start()
        buy()
        fill()
        take()
    }

    private fun buy() {
        val makeButton: Button = findViewById(R.id.make_button)
        val textInput: EditText = findViewById(R.id.make_text)
        makeButton.setOnClickListener {
            if (textInput.text?.toString()?.trim()?.equals("")!!) {
                Toast.makeText(this, R.string.make_text, Toast.LENGTH_SHORT).show()
            } else {
                val order = Order(textInput.text.toString().trim())
                controller.buy(order = order)
            }
        }
    }

    private fun fill() {
        val fillButton: Button = findViewById(R.id.fill_button)
        val waterInput: EditText = findViewById(R.id.water_input)
        val milkInput: EditText = findViewById(R.id.milk_input)
        val coffeeBeansInput: EditText  = findViewById(R.id.coffee_beans_input)
        val disposableCupsInput: EditText = findViewById(R.id.disposable_cups_input)
        fillButton.setOnClickListener {
            if (waterInput.text?.toString()?.trim()?.equals("")!!) {
                Toast.makeText(this, R.string.enter_water, Toast.LENGTH_SHORT).show()
            } else if (milkInput.text?.toString()?.trim()?.equals("")!!) {
                Toast.makeText(this, R.string.enter_milk, Toast.LENGTH_SHORT).show()
            } else if (coffeeBeansInput.text?.toString()?.trim()?.equals("")!!) {
                Toast.makeText(this, R.string.enter_coffee_beans, Toast.LENGTH_SHORT).show()
            } else if (disposableCupsInput.text?.toString()?.trim()?.equals("")!!) {
                Toast.makeText(this, R.string.enter_disposable_cups, Toast.LENGTH_SHORT).show()
            } else {
                    val resources = Resources.ChangeRes(water = waterInput.text.toString().trim().toInt(),
                        milk = milkInput.text.toString().trim().toInt(),
                        coffeeBeans = coffeeBeansInput.text.toString().trim().toInt(),
                        cups = disposableCupsInput.text.toString().trim().toInt())
                    controller.fill(resources)
            }
        }
    }

    private fun take() {
        val takeButton: Button = findViewById(R.id.take_button)
        takeButton.setOnClickListener {
            controller.take()
        }
    }

    fun showInfoRes(info: String) {
        val remaining: TextView = findViewById(R.id.remaining)
        remaining.text = info
    }

    fun showInfo(info: String) {
        Toast.makeText(this@MainActivity, info, Toast.LENGTH_SHORT).show()
    }
}