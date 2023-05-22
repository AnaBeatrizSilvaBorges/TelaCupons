package com.example.telacupons



import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Paint.Align
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material.Text
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.compose.rememberNavController
import com.example.telacupons.ui.theme.TelaCuponsTheme
import com.example.telacupons.ui.theme.c1
import com.example.telacupons.ui.theme.c2
import java.time.format.TextStyle
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.NonDisposableHandle.parent


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TelaCuponsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(255,255,255)
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}


@Composable
fun RoundedTextField(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
    placeholder: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    value: String,
    onValueChange: (String) -> Unit
) {



    var searchText by remember { mutableStateOf("") }

    OutlinedTextField(
        value = searchText,
        onValueChange = { newText -> searchText = newText },
        modifier = modifier
            .fillMaxWidth()
            .height(84.dp)
            .padding(16.dp)
            .background(color = Color(240, 240, 240), shape = shape)
            .clip(shape),
        textStyle = MaterialTheme.typography.body1,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            placeholderColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}


@Composable
fun Greeting(name: String) {

    var isVisible by remember { mutableStateOf(false) }


    val selectedRow = remember { mutableStateOf(-1) }


    fun showRowDetails(rowId: Int) {
        selectedRow.value = rowId
    }

    fun hideRowDetails() {
        selectedRow.value = -1
    }


    var Pesquisastate by remember {
        mutableStateOf("")
    }

    val navController = rememberNavController()

    // cor 2
    var VERDE by remember {
        mutableStateOf(Color(8, 113, 19))
    }

    var DisponiveisClick by remember {
        mutableStateOf(true)
    }

    var ResgatadosClick by remember {
        mutableStateOf(false)
    }

    var color1 by remember {
        mutableStateOf(Color(53, 155, 55))
    }
    var color2 by remember {
        mutableStateOf(Color.Transparent)
    }

    var MARROM by remember {
        mutableStateOf(Color(181, 116, 48))
    }
    val context = LocalContext.current
    //2
    var TRANSPARENTE by remember {
        mutableStateOf(Color.Transparent)
    }


    var DispoVisibility by remember {
        mutableStateOf(false)
    }

    var searchText by remember { mutableStateOf("") }

    var selectedWord by remember { mutableStateOf("disponiveis") }

    var showAlert = remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color(255, 255, 255))


    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = stringResource(id = R.string.foto_logo,),
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(top = 5.dp)
                .width(60.dp)
                .height(51.dp)
        )

        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Black, fontSize = 18.sp,)) {
                    append("SEU SALDO:")
                }
                append(' ')
                withStyle(style = SpanStyle(color = Color(30, 122, 22), fontSize = 19.sp)) {
                    append("200")
                }
                append(' ')
                withStyle(style = SpanStyle(color = Color.Black, fontSize = 19.sp)) {
                    append("PONTOS")
                }

            },
            modifier = Modifier.align(CenterHorizontally),
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )

        RoundedTextField(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            placeholder = {
                Text(
                    "Busque por mercados por aqui...",
                    style = MaterialTheme.typography.body1.copy(color = Color.White),
                    modifier = Modifier.fillMaxSize()
                )
            },
            leadingIcon = {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "Ícone de pesquisa",
                    tint = Color.White
                )
            },
            value = searchText,
            onValueChange = { searchText = it }
        )




        Text(
            text = stringResource(id = R.string.texto),
            modifier = Modifier.padding(start = 5.dp, end = 5.dp),
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 13.dp, end = 15.dp),
            horizontalArrangement = Arrangement.Center
        ) {

            Row(
                modifier = Modifier
                    .background(
                        color = Color.White, shape = RoundedCornerShape(7.dp)
                    ), verticalAlignment = Alignment.CenterVertically
            ) {

                Text(text = "Disponíveis", modifier = Modifier
                    .background(
                        color1,
                        shape = RoundedCornerShape(
                            topStart = 4.dp,
                            bottomStart = 4.dp
                        )
                    )
                    .clickable {
                        selectedWord = "disponiveis"
                        DisponiveisClick = true
                        ResgatadosClick = false
                        isVisible = true
                        color1 = Color(53, 155, 55)
                        color2 = Color.Transparent

                    }
                    .padding(
                        top = 4.dp,
                        bottom = 4.dp
                    )

                    .width(130.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center)


                Text(text = "Resgatados",
                    modifier = Modifier
                        .background(
                            color2,
                            shape = RoundedCornerShape(topEnd = 4.dp, bottomEnd = 4.dp)
                        )
                        .clickable {
                            selectedWord = "resgatados"
                            DisponiveisClick = false
                            ResgatadosClick = true
                            isVisible = false
                            color2 = Color(181, 116, 48)
                            color1 = Color.Transparent
                        }
                        .padding(
                            top = 4.dp,
                            bottom = 4.dp,
                        )
                        .width(130.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center)

            }
        }

        Column {

            when (selectedWord) {
                "disponiveis" -> {

                    // Primeiro Card
                    Box(
                        modifier = Modifier
                            .height(130.dp)
                            .fillMaxWidth()
                    ) {
                        Card(
                            modifier = Modifier
                                .width(400.dp)
                                .height(130.dp)
                                .padding(start = 25.dp, end = 25.dp, top = 15.dp),
                            shape = RoundedCornerShape(15.dp),
                            backgroundColor = Color(53, 155, 55)

                        ) {

                            Row(
                                modifier = Modifier.padding(bottom = 25.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.logo_sem_fundo),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(120.dp)
                                        .padding(start = 10.dp)

                                )

                            }

                            Column(
                                modifier = Modifier.padding(start = 80.dp, top = 15.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            )
                            {

                                Text(
                                    modifier = Modifier,
                                    textAlign = TextAlign.Justify,
                                    text = "25% OFF",
                                    fontSize = 16.sp,
                                    color = Color.White
                                )

                                Text(
                                    modifier = Modifier,
                                    //textAlign = TextAlign.Center,
                                    text = "Em compras Extra",
                                    fontSize = 16.sp,
                                    color = Color.White
                                )

                                Row() {

                                    Box(
                                        modifier = Modifier
                                            .width(95.dp)
                                            .height(80.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(R.drawable.retangulo),
                                            contentDescription = "Imagem",
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(80.dp)
                                        )
                                        Text(
                                            text = "100 pontos",
                                            modifier = Modifier
                                                .align(Alignment.Center),
                                            color = Color.White,
                                            fontSize = 14.sp
                                        )
                                    }

                                    Spacer(modifier = Modifier.padding(5.dp))

                                    Row(modifier = Modifier.padding(top = 13.dp))
                                    {
                                        Button(
                                            onClick = {
                                                val toCupomActivity =
                                                    Intent(context, CupomActivity::class.java)
                                                context.startActivity(toCupomActivity)
                                            }, modifier = Modifier
                                                .width(92.dp)
                                                .height(32.dp),
                                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                                        )
                                        {
                                            Text(text = "PEGUE", color = Color(8, 113, 19))

                                        }
                                    }

                                }

                            }

                        }

                        Box(
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .size(40.dp)
                                .align(Alignment.CenterStart)
                                .offset(x = (-1).dp)
                                .background(Color.White, shape = CircleShape)
                        ) {

                        }
                        Box(
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .size(40.dp)
                                .align(Alignment.CenterEnd)
                                .offset(x = (2).dp)
                                .background(Color.White, shape = CircleShape)
                        )


                    }

                    // Segundo card

                    Box(
                        modifier = Modifier
                            .height(130.dp)
                            .fillMaxWidth()
                    ) {
                        Card(
                            modifier = Modifier
                                .width(400.dp)
                                .height(130.dp)
                                .padding(start = 25.dp, end = 25.dp, top = 15.dp),
                            shape = RoundedCornerShape(15.dp),
                            backgroundColor = Color(53, 155, 55)

                        ) {

                            Row(
                                modifier = Modifier.padding(bottom = 25.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.logo_carrefour),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(120.dp)
                                        .padding(start = 10.dp)

                                )

                            }

                            Column(
                                modifier = Modifier.padding(start = 80.dp, top = 15.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            )
                            {

                                Text(
                                    modifier = Modifier,
                                    textAlign = TextAlign.Justify,
                                    text = "25% OFF",
                                    fontSize = 16.sp,
                                    color = Color.White
                                )

                                Text(
                                    modifier = Modifier,
                                    //textAlign = TextAlign.Center,
                                    text = "Em compras Carrefour",
                                    fontSize = 16.sp,
                                    color = Color.White
                                )

                                Row() {

                                    Box(
                                        modifier = Modifier
                                            .width(95.dp)
                                            .height(80.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(R.drawable.retangulo),
                                            contentDescription = "Imagem",
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(80.dp)
                                        )
                                        Text(
                                            text = "100 pontos",
                                            modifier = Modifier
                                                .align(Alignment.Center),
                                            color = Color.White,
                                            fontSize = 14.sp
                                        )
                                    }

                                    Spacer(modifier = Modifier.padding(5.dp))

                                    Row(modifier = Modifier.padding(top = 13.dp))
                                    {
                                        Button(
                                            onClick = {
                                                val toCupomActivity =
                                                    Intent(context, CupomCarrefour::class.java)
                                                context.startActivity(toCupomActivity)
                                            }, modifier = Modifier
                                                .width(92.dp)
                                                .height(32.dp),
                                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                                        )
                                        {
                                            Text(text = "PEGUE", color = Color(8, 113, 19))

                                        }
                                    }

                                }

                            }


                        }

                        Box(
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .size(40.dp)
                                .align(Alignment.CenterStart)
                                .offset(x = (-1).dp)
                                .background(Color.White, shape = CircleShape)
                        ) {

                        }
                        Box(
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .size(40.dp)
                                .align(Alignment.CenterEnd)
                                .offset(x = (2).dp)
                                .background(Color.White, shape = CircleShape)
                        )

                    }


                }

                "resgatados" -> {


                    // Primeiro Card
                    Box(
                        modifier = Modifier
                            .height(130.dp)
                            .fillMaxWidth()
                    )
                    {

                        Card(
                            modifier = Modifier
                                .width(400.dp)
                                .height(130.dp)
                                .padding(start = 25.dp, end = 25.dp, top = 15.dp),
                            shape = RoundedCornerShape(15.dp),
                            backgroundColor = Color(181, 116, 48)
                        )
                        {


                            Row(
                                modifier = Modifier.padding(bottom = 25.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.logo_sem_fundo),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(120.dp)
                                        .padding(start = 10.dp)

                                )

                            }

                            Column(
                                modifier = Modifier.padding(start = 80.dp, top = 15.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            )
                            {

                                Text(
                                    modifier = Modifier,
                                    textAlign = TextAlign.Justify,
                                    text = "25% OFF",
                                    fontSize = 16.sp,
                                    color = Color.White
                                )

                                Text(
                                    modifier = Modifier,
                                    //textAlign = TextAlign.Center,
                                    text = "Em compras Extra",
                                    fontSize = 16.sp,
                                    color = Color.White
                                )

                                Row() {

                                    Box(
                                        modifier = Modifier
                                            .width(95.dp)
                                            .height(80.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(R.drawable.retangulo),
                                            contentDescription = "Imagem",
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(80.dp)
                                        )
                                        Text(
                                            text = "100 pontos",
                                            modifier = Modifier
                                                .align(Alignment.Center),
                                            color = Color.White,
                                            fontSize = 14.sp
                                        )
                                    }

                                    Spacer(modifier = Modifier.padding(5.dp))

                                    Row(modifier = Modifier.padding(top = 13.dp))
                                    {
                                        Button(
                                            onClick = {
                                                val toCupomActivity =
                                                    Intent(context, CupomRes::class.java)
                                                context.startActivity(toCupomActivity)
                                            }, modifier = Modifier
                                                .width(92.dp)
                                                .height(32.dp),
                                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                                        )
                                        {
                                            Text(text = "VEJA", color = Color(181, 116, 48))

                                        }


                                    }


                                }
                            }
                        }

                        Box(
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .size(40.dp)
                                .align(Alignment.CenterStart)
                                .offset(x = (-1).dp)
                                .background(Color.White, shape = CircleShape)
                        ) {

                        }
                        Box(
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .size(40.dp)
                                .align(Alignment.CenterEnd)
                                .offset(x = (2).dp)
                                .background(Color.White, shape = CircleShape)
                        )
                    }

                    // Segundo Card

                    Box(
                        modifier = Modifier
                            .height(130.dp)
                            .fillMaxWidth()
                    )
                    {

                        Card(
                            modifier = Modifier
                                .width(400.dp)
                                .height(130.dp)
                                .padding(start = 25.dp, end = 25.dp, top = 15.dp),
                            shape = RoundedCornerShape(15.dp),
                            backgroundColor = Color(181, 116, 48)
                        )
                        {


                            Row(
                                modifier = Modifier.padding(bottom = 25.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.logo_carrefour),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(120.dp)
                                        .padding(start = 10.dp)

                                )

                            }

                            Column(
                                modifier = Modifier.padding(start = 80.dp, top = 15.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            )
                            {

                                Text(
                                    modifier = Modifier,
                                    textAlign = TextAlign.Justify,
                                    text = "25% OFF",
                                    fontSize = 16.sp,
                                    color = Color.White
                                )

                                Text(
                                    modifier = Modifier,
                                    //textAlign = TextAlign.Center,
                                    text = "Em compras Carrefour",
                                    fontSize = 16.sp,
                                    color = Color.White
                                )

                                Row() {

                                    Box(
                                        modifier = Modifier
                                            .width(95.dp)
                                            .height(80.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(R.drawable.retangulo),
                                            contentDescription = "Imagem",
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(80.dp)
                                        )
                                        Text(
                                            text = "100 pontos",
                                            modifier = Modifier
                                                .align(Alignment.Center),
                                            color = Color.White,
                                            fontSize = 14.sp
                                        )
                                    }

                                    Spacer(modifier = Modifier.padding(5.dp))

                                    Row(modifier = Modifier.padding(top = 13.dp))
                                    {
                                        Button(
                                            onClick = { showAlert.value = true }, modifier = Modifier
                                                .width(92.dp)
                                                .height(32.dp),
                                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                                        )
                                        {
                                            Text(text = "VEJA", color = Color(181, 116, 48))

                                        }


                                        }
                                }

                                }
                            }



                        Box(
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .size(40.dp)
                                .align(Alignment.CenterStart)
                                .offset(x = (-1).dp)
                                .background(Color.White, shape = CircleShape)
                        ) {

                        }
                        Box(
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .size(40.dp)
                                .align(Alignment.CenterEnd)
                                .offset(x = (2).dp)
                                .background(Color.White, shape = CircleShape)
                        )
                    }



                }


            }
        }



    }

    if (showAlert.value) {


        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Card(
                modifier = Modifier
                    .width(322.dp)
                    .height(130.dp)
                    .clickable {
                        // Ação de clique do card
                    }
            ) {
                Column(modifier = Modifier.padding(top = 5.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Deseja Proseguir?",

                        )

                    Text(
                        text = "Ao clicar em na opção PEGUE, o código aparecerá e ao sair vc não poderá ver ele novamente",
                        fontSize = 14.sp, modifier = Modifier.padding(start = 15.dp, end =10.dp )
                    )


                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center)
                    {
                        Text(
                            text = "Sim",
                            modifier = Modifier.clickable {
                                // Ação para "Sim"
                            }
                        )

                        Spacer(modifier = Modifier.padding(8.dp))

                        Text(
                            text = "Não",
                            modifier = Modifier.clickable {
                                // Ação para "Não"
                            }
                        )
                    }

                }

            }

        }



    }


}








@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TelaCuponsTheme {
        Greeting("Android")
    }
}
