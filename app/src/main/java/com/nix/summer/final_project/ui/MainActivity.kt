package com.nix.summer.final_project.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.nix.summer.final_project.*
import com.nix.summer.final_project.adapters.Contract
import com.nix.summer.final_project.adapters.MainPresenter

import com.nix.summer.final_project.core.Model
import com.nix.summer.final_project.core.entities.Order
import com.nix.summer.final_project.core.entities.Resources

class MainActivity : AppCompatActivity(), Contract.View {

    private val model = Model()
    override var presenter = MainPresenter(model)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attach(this)
        presenter.start()
        buy()
        fill()
        take()
    }

    override fun buy() {
        val makeButton: Button = findViewById(R.id.make_button)
        val textInput: EditText = findViewById(R.id.make_text)
        makeButton.setOnClickListener {
            if (textInput.text?.toString()?.trim()?.equals("")!!) {
                Toast.makeText(this, R.string.make_text, Toast.LENGTH_SHORT).show()
            } else {
                val order = Order(textInput.text.toString().trim())
                presenter.buy(order = order)
            }
        }
    }

    override fun fill() {
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
                    val resources = Resources.ChangeRes(
                        water = waterInput.text.toString().trim().toInt(),
                        milk = milkInput.text.toString().trim().toInt(),
                        coffeeBeans = coffeeBeansInput.text.toString().trim().toInt(),
                        cups = disposableCupsInput.text.toString().trim().toInt()
                    )
                presenter.fill(resources)
            }
        }
    }

    override fun take() {
        val takeButton: Button = findViewById(R.id.take_button)
        takeButton.setOnClickListener {
            presenter.take()
        }
    }

    override fun showInfoRes(info: String) {
        val remaining: TextView = findViewById(R.id.remaining)
        remaining.text = info
    }

    override fun showInfo(info: String) {
        Toast.makeText(this@MainActivity, info, Toast.LENGTH_SHORT).show()
    }
}