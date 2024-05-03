import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import org.jetbrains.compose.ui.tooling.preview.Preview

import tabs.home.HomeTab
import tabs.explore.ExploreTab
import tabs.chat.ChatTab

@Composable
@Preview
fun App() {
    MaterialTheme {
        TabNavigator(HomeTab){
            Scaffold(
                bottomBar = {
                    BottomNavigation {
                        TabNavigationItem(HomeTab)
                        TabNavigationItem(ExploreTab)
                        TabNavigationItem(ChatTab)
                    }
                }
            ) {
                CurrentTab()
            }
        }
    }
}
@Composable
private fun RowScope.TabNavigationItem(tab: Tab){
    val tabNavigator = LocalTabNavigator.current

    BottomNavigationItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab},
        label = { Text(tab.options.title) },
        icon = { Icon(painter = tab.options.icon ?: rememberVectorPainter(Icons.Default.Warning), contentDescription = tab.options.title) }
    )
}