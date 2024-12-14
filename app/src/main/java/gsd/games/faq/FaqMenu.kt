package gsd.games.faq

import android.animation.*
import android.view.*
import android.widget.*
import gsd.games.R

class FaqMenu(
    private val faqItem: LinearLayout,
    private val imgFaq: ImageView,
    private val txtFaqFull: TextView
) {
    private var isExpanded = false

    init {
        txtFaqFull.visibility = View.GONE
        txtFaqFull.layoutParams.height = 0
        txtFaqFull.requestLayout()
        imgFaq.setOnClickListener { toggle() }
    }

    private fun toggle() {
        isExpanded = !isExpanded

        if (isExpanded) {
            animateExpand(txtFaqFull)
            imgFaq.setImageResource(R.drawable.close)
            faqItem.setBackgroundResource(R.drawable.faq_back)
        } else {
            animateCollapse(txtFaqFull)
            imgFaq.setImageResource(R.drawable.plus)
            faqItem.setBackgroundResource(R.drawable.menu)
        }
    }

    private fun animateExpand(view: View) {
        view.measure(
            View.MeasureSpec.makeMeasureSpec((view.parent as View).width, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.UNSPECIFIED
        )
        val targetHeight = view.measuredHeight

        view.layoutParams.height = 0
        view.visibility = View.VISIBLE

        val animator = ValueAnimator.ofInt(0, targetHeight)
        animator.addUpdateListener { animation ->
            val value = animation.animatedValue as Int
            view.layoutParams.height = value
            view.requestLayout()
        }
        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                view.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
            }
        })
        animator.duration = 300
        animator.start()
    }

    private fun animateCollapse(view: View) {
        val initialHeight = view.measuredHeight

        val animator = ValueAnimator.ofInt(initialHeight, 0)
        animator.addUpdateListener { animation ->
            val value = animation.animatedValue as Int
            view.layoutParams.height = value
            view.requestLayout()
        }
        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                view.visibility = View.GONE
            }
        })
        animator.duration = 300
        animator.start()
    }
}
