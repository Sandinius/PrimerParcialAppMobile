package com.example.primerparcialappmobilesantiagoandini

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController



@Composable
fun MontoRetirado(navController: NavController, monto: String){

    Column(
        Modifier
            .padding(all = 30.dp)
            .fillMaxWidth()
    ){
        Spacer(modifier = Modifier.height(12.dp))

        Text(text = "Usted a retirado $$monto con exito de su cuenta bancaria")

        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                    navController.navigate("Transferir")
            },
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Volver")
        }

    }
}
