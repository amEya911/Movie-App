package eu.tutorials.movieapp.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import eu.tutorials.movieapp.R
import eu.tutorials.movieapp.models.Data
import eu.tutorials.movieapp.viewModel.MovieViewModel


@Composable
fun HomeScreen(navController: NavHostController) {

    val movieViewModel = viewModel<MovieViewModel>()
    val state = movieViewModel.state

    Scaffold(
        modifier = Modifier.background(Color(0xFFEADBC8)),
        topBar = {
            TopBar()
        },
        containerColor = Color.Transparent
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.Transparent)
        ) {
            items(state.movies.size) {
                if (it >= state.movies.size - 1 && !state.endReached && !state.isLoading) {
                    movieViewModel.loadNextItems()
                }
                ItemUi(itemIndex = it, movieList = state.movies, navController = navController)
            }
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemUi(itemIndex: Int, movieList: List<Data>, navController: NavHostController) {

    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(10.dp)
            .clickable {
                navController.navigate("${Screen.DetailScreen.route}/${movieList[itemIndex].id}")
            },
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
            AsyncImage(
                model = movieList[itemIndex].poster,
                contentDescription = movieList[itemIndex].title,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(6.dp)
                    .background(Color.LightGray.copy(0.7f))
            ) {
                Text(
                    text = movieList[itemIndex].title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .basicMarquee(),
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.imdb),
                        contentDescription = "imdb",
                        modifier = Modifier
                            .size(30.dp)
                            .padding(start = 6.dp),
                        tint = Color.Yellow
                    )
                        Text(
                            text = movieList[itemIndex].imdb_rating,
                            textAlign = TextAlign.Start,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 8.dp, top = 5.dp),
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            maxLines = 2
                        )
                    }
                }

            }
        }

    }




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "Movies App", color = Color.Black, fontSize = 26.sp) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFFB5C18E)
        )
    )
}
