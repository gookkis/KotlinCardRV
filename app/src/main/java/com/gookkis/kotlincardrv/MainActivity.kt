package com.gookkis.kotlincardrv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TeamListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val listTeam = listOf(
            Team(
                nameTeam = "Everton",
                imageTeam = "https://www.thesportsdb.com/images/media/team/badge/eqayrf1523184794.png"
            ),
            Team(
                nameTeam = "Man City",
                imageTeam = "https://www.thesportsdb.com/images/media/team/badge/vwpvry1467462651.png"
            ),
            Team(
                nameTeam = "Liverpool",
                imageTeam = "https://www.thesportsdb.com/images/media/team/badge/uvxuqq1448813372.png"
            ),
            Team(
                nameTeam = "Man United",
                imageTeam = "https://www.thesportsdb.com/images/media/team/badge/xzqdr11517660252.png"
            ),
            Team(
                nameTeam = "Chelsea",
                imageTeam = "https://www.thesportsdb.com/images/media/team/badge/yvwvtu1448813215.png"
            )
        )

        //val teamAdapter = TeamAdapter(listTeam)
        var groupAdapter = GroupAdapter<ViewHolder>()

        listTeam.map {
            groupAdapter.add(TeamItem(it, this))
        }

        rv_team.apply {
            //layoutManager = LinearLayoutManager(this@MainActivity)
            layoutManager = GridLayoutManager(this@MainActivity,2)
            adapter = groupAdapter
        }

    }

    override fun onTeamClicked(team: Team) {
        Snackbar.make(root, team.nameTeam,Snackbar.LENGTH_SHORT).show()
    }

    override fun onTextClicked(team: Team) {
        Snackbar.make(root, "Text Clicked "+team.nameTeam,Snackbar.LENGTH_SHORT).show()
    }

}
