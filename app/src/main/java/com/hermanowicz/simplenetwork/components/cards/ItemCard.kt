package com.hermanowicz.simplenetwork.components.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hermanowicz.simplenetwork.data.model.User

@Composable
fun SingleUserItemCard(
    user: User,
    onClickUser: (Int) -> Unit
) {
    val email = user.email ?: ""
    val firstName = user.firstName ?: ""
    val lastName = user.lastName ?: ""

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .padding(vertical = 8.dp, horizontal = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .clickable {
                    onClickUser(user.id!!)
                }
        ) {
            Text(text = email, fontSize = 20.sp)
            Text(text = "$firstName $lastName", fontSize = 18.sp)
        }
    }
}