package com.rarvs.activityresult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.widget.AbsListView
import android.widget.ArrayAdapter
import android.widget.ListView

class StatesListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_states_list)

        val listView = ListView(this)
        setContentView(listView)
        val statesList = resources.getStringArray(R.array.states)
        val listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, statesList)
        listView.adapter = listAdapter
        listView.choiceMode = AbsListView.CHOICE_MODE_SINGLE
        val state = intent.getStringExtra(EXTRA_STATE)
        //if a state has been selected
        if (state != null){
            val position = statesList.indexOf(state)
            //check radio for previously selected state
            listView.setItemChecked(position, true)
        }
        //add extra with the state name to an intent  and finish the activity
        listView.setOnItemClickListener { l, _, position, _ ->
            val result = l.getItemAtPosition(position) as String
            val it = Intent()
            it.putExtra(EXTRA_RESULT, result)
            setResult(Activity.RESULT_OK, it)
            finish()
        }
    }
    companion object{
        const val EXTRA_STATE = "estado"
        const val EXTRA_RESULT = "result"
    }
}