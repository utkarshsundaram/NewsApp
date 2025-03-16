package com.utkarshsundaram.newsapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.utkarshsundaram.newsapp.R
import com.utkarshsundaram.newsapp.data.model.Article

@Composable
fun NewsListScreen(articles:List<Article>) {
    LazyColumn {
        items(articles) { article ->
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Row(Modifier.fillMaxWidth().padding(12.dp),
                         horizontalArrangement = Arrangement.spacedBy(12.dp),
                         verticalAlignment = Alignment.CenterVertically) {
                    AsyncImage(
                        model = article.urlToImage,
                        contentDescription = "Image",
                        placeholder = painterResource(id = R.drawable.ic_placeholder),
                        error = painterResource(id = R.drawable.ic_placeholder_error),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(150.dp)


                    )
                    Column(Modifier.wrapContentSize(),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(article.title, fontWeight = FontWeight.Bold)
                        article.author?.let { author ->
                            Text(author)
                        }
                        article.content?.let { content ->
                            Text(content)
                        }
                    }

                }
                HorizontalDivider(color = Color.Black, thickness = 5.dp)
            }
        }

    }
}