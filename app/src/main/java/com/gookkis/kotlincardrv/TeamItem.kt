package com.gookkis.kotlincardrv

import com.squareup.picasso.Picasso
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_team.view.*

class TeamItem(private val teams: Team, private val listener: TeamListener) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.tv_team.text = teams.nameTeam
        Picasso.get().load(teams.imageTeam).into(viewHolder.itemView.img_team)

        viewHolder.itemView.img_team.setOnClickListener {
            listener.onTeamClicked(teams)
        }

        viewHolder.itemView.tv_team.setOnClickListener {
            listener.onTextClicked(teams)
        }

    }

    override fun getLayout() = R.layout.item_grid_team

}

interface TeamListener {
    fun onTeamClicked(team: Team)
    fun onTextClicked(team: Team)
}
