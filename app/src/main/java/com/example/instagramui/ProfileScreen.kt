package com.example.instagramui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen()
{
    var selectedtabIndex by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(name = "pranjal_dubey27", modifier = Modifier.padding(10.dp))
        Spacer(modifier = Modifier.height(4.dp))
        ProfileDescription()
        Spacer(modifier = Modifier.height(10.dp))
        Buttons()
        Spacer(modifier = Modifier.height(25.dp))
        Highlights( highlights = listOf(
            ImageWithText(
                image = painterResource(id = R.drawable.highlight1),
                text = "Friends"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.profile),
                text = "Chandigarh"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.pjdy),
                text = "Creative Me"
            ),
        ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        PostTabs(
            imageWithText = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_grid),
                    text = "Posts"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_reels),
                    text = "Reels"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_igtv),
                    text = "IGTV"
                )
            ),
            )
        {
            selectedtabIndex = it
        }

        when(selectedtabIndex)
        {
            0 -> PostSection(
                posts = listOf(
                    painterResource(id = R.drawable.post1),
                    painterResource(id = R.drawable.post2),
                    painterResource(id = R.drawable.post3),
                    painterResource(id = R.drawable.post4),
                    painterResource(id = R.drawable.post5),
                    painterResource(id = R.drawable.post6),
                    painterResource(id = R.drawable.post7)
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun TopBar(
    name : String,
    modifier: Modifier = Modifier
)
{
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(25.dp)
        )
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            overflow = TextOverflow.Ellipsis
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(25.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )
    }
}


@Composable
fun ProfileDescription(
    modifier: Modifier = Modifier
)
{
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
        ){
            RoundImage(
                image = painterResource(id = R.drawable.profile),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))
        }
        ProfileDescription(title = "IIIT Bhopal'25", description = "Deserve before desire !!", url = "https://github.com/dubey2709", followedBy = listOf("Romit","Vaibahv","Kshitij") , otherCount = 377 )
    }
}


@Composable
fun RoundImage(
    image : Painter,
    modifier: Modifier = Modifier
)
{
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                2.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
fun StatSection(
    modifier: Modifier = Modifier
)
{
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Stat(number = "8", text = "Posts")
        Stat(number = "380", text = "Followers")
        Stat(number = "473", text = "Following" )
    }
}

@Composable
fun Stat(
    number : String,
    text : String,
    modifier: Modifier = Modifier
)
{
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = number,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = modifier.height(4.dp))
        Text(text = text)
    }
}

@Composable
fun ProfileDescription(
    title : String,
    description : String,
    url : String,
    followedBy : List<String>,
    otherCount : Int
)
{
    val letterSpacing = 0.5.sp
    val lineSpacing = 20.sp

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)) {
        Text(
            text = title,
            fontWeight =  FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineSpacing
        )
        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineSpacing
        )
        Text(
            text = url,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineSpacing
        )
        Text(
            text = buildAnnotatedString {
                val boldStyle = SpanStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                append("Followed by ")
                followedBy.forEachIndexed { index, s ->
                    pushStyle(boldStyle)
                    append(s)
                    pop()
                    if(index<followedBy.size-1)
                    {
                        append(", ")
                    }
                }
                if(otherCount>2)
                {
                    append(" and ")
                    pushStyle(boldStyle)
                    append("$otherCount others")
                }
            },
            letterSpacing = letterSpacing,
            lineHeight = lineSpacing
        )
    }
}

@Composable
fun Buttons(
    modifier: Modifier = Modifier
)
{
    val minWidth = 170.dp
    val height = 35.dp
    Row (
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier.fillMaxWidth()
    ){
        ActionButtons(
            text = "Edit profile",
            modifier = modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButtons(
            text = "Share profile",
            modifier = modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButtons(
            icon = Icons.Default.Person,
            modifier = modifier
                .defaultMinSize(minWidth = 40.dp)
                .height(height)
        )
    }
}


@Composable
fun ActionButtons(
    modifier: Modifier = Modifier,
    text : String? = null,
    icon : ImageVector? = null
)
{
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 2.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(6.dp)
    ) {
        if(text!=null)
        {
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        if(icon != null)
        {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}


@Composable
fun Highlights(
    modifier: Modifier = Modifier,
    highlights: List<ImageWithText>
)
{
    LazyRow(modifier = modifier)
    {
        items(highlights.size)
        {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(end = 15.dp)
            ) {
                RoundImage(
                    image = highlights[it].image,
                    modifier = Modifier.size(70.dp)
                )
                Text(
                    text = highlights[it].text,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}


@Composable
fun PostTabs(
    modifier: Modifier = Modifier,
    imageWithText: List<ImageWithText>,
    onSelectedIndex : (selectedIndex : Int) -> Unit
)
{
    var selectedTabIndex by remember{
        mutableStateOf(0)
    }

    val inactiveColor  = Color(0xFF777777)

    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        imageWithText.forEachIndexed{ index, item ->
            Tab(
                selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index;
                    onSelectedIndex(index)
                }) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if(selectedTabIndex == index) Color.Black else inactiveColor,
                    modifier = modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }

    }


}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostSection(
    posts : List<Painter>,
    modifier: Modifier = Modifier
)
{
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier.scale(1.01f)
        )
    {
        items(posts.size)
        {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }
}