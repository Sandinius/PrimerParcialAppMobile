package com.example.primerparcialappmobilesantiagoandini

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.material3.Button

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


var montoHard = 1000000.0
@Composable
fun RetirarDineroPage(navController: NavController){
    var montoRetirar by rememberSaveable { mutableStateOf("") }
    var retirarMesagge by rememberSaveable { mutableStateOf("") }

    Column(
        Modifier
            .padding(all = 30.dp)
            .fillMaxWidth()
    ){
        Text(text = "Bienvenido a la  App de retiro de dinero", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(12.dp))

        Text(text = "Este es su dinero disponible: $$montoHard", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(12.dp))

        Text(text = "Ingrese el monto a retirar")
        TextField(
            value = montoRetirar,
            onValueChange = {  value ->
                if (value.matches(Regex("^\\d*\\.?\\d*\$"))) {
                    montoRetirar = value
                }},
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)

        )

        Spacer(modifier = Modifier.height(12.dp))


        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                val montoRetirarInt = montoRetirar.toDoubleOrNull() ?: 0.0
                if (montoRetirarInt > montoHard) {
                    retirarMesagge = "❌ El monto excede el dinero disponible"
                } else if(montoRetirarInt == 0.0) {
                    retirarMesagge = "❌ El monto no puede ser 0"
                }else {
                    retirarMesagge = "✅ Retiro exitoso"
                    montoHard = montoHard - montoRetirarInt
                    navController.navigate("MontoRetirado/${montoRetirarInt.toString()}")
                }
            },
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Ingresar")
        }
        if (retirarMesagge.isNotEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = retirarMesagge)
        }
    }
}


