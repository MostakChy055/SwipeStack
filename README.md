# SwipeStack

This repository contains the concepts I have learnt about mobile application development over the years. And the name of the repo is inspired from the layered nature of development.

So, when we look at our mobile screen ever wondered how they come to be? How are they generated? 
First system Measures each viewgroup (say a textbox) specified dimensions, padding etc. Once that is done system moves onto Layout phase. In this phase system determines position of each views in the parent container. This involves calculating co-ordinates, layout rules defined by the parent container (relative positioning, constraints etc). Then in the draw phase system renders the view leveraging the information that it gathered in the "Measure", "Layout" phase.

[Uploading DALL·E 2025-01-18 02.45.19 - A clean and modern illustration representing a flow process in a minimalist style. The process includes three stages labeled 'Measure,' 'Layout,' and .webp…]()


Now, there comes an issue. Some layouts like linear, relative layouts utilize nesting of viewgroups. And this makes the whole process slow. Why?  
As mentioned in the "Layout" phase system calculates stuffs like co-ordinates, layout rules etc. If there's too many nesting of groups then the system has to do more of these calculation and it'll in turn make it's moving to "Draw" phase late right? And we do not want that to happen. To get around this problem what constraint layout does is promote FlatView hierarchy. With this it can achieve intricate arrangements without relying on nested layouts. This reduces number of Measures and Layout phases needed to perform.

# Constraint Layout:
There are many features that are provided by constraint layout. Such as match_constraint, aspect ratio etc
## Match Constraint
* This is a setting for a View's width or height in ConstraintLayout. Instead of specifying a fixed size *4* (like *100dp*) or 
wrap_content (adjusts to content size), you set it to 0dp and then use constraints to define its size.  The View will then expand
to fill the space defined by its constraints. Imagine it stretching like a rubber band between the constraints. 

* Modifying Match Constraints Behavior:
While "Match Constraints" makes the view expand to fill available space, you can fine-tune this behavior with these 
attributes:
layout_constraintWidth_min: This sets a minimum width for the View. Even if the constraints would allow it to be smaller,
 it will never shrink below this minimum. The value is specified in dp (density-independent pixels). 
layout_constraintWidth_max: This sets a maximum width for the View. Even if the constraints would allow it to be larger,
it will never expand beyond this maximum. The value is also specified in *dp*

* Special Case: Single Constraint:
If a View using "Match Constraints" only has a constraint on one side (e.g., only constrained to the left edge of the 
parent), it will behave like wrap_content. It will expand to fit its content. 
Size Ratio:
When using "Match Constraints" for either width or height, you can also set a size ratio. This is useful for maintaining 
aspect ratios (e.g., making a view always twice as wide as it is tall). You set this using the 
layout_constraintDimensionRatio attribute. 

* Example:
Let's say you have a TextView.
If you set its width to 0dp and constrain it to the left and right edges of the parent, it will stretch to fill the entire width. 
If you then add *layout_constraintWidth_min="50dp"*, the TextView will never be narrower than *50dp*, even if the parent is 
very narrow. 
If you add *layout_constraintWidth_max="200dp"*, the TextView will never be wider than *200dp*, even if the parent is very 
wide. 
In Summary:
"Match Constraints" provides a flexible way to size Views in ConstraintLayout. By combining it with minimum and 
maximum width/height values and size ratios, you have precise control over how your Views behave in different screen
sizes and orientations.

  ![image](https://github.com/user-attachments/assets/a241b1c0-a076-4321-ac9c-227ce7dceab9)

  ![image](https://github.com/user-attachments/assets/c9006d49-ca61-4409-8864-91944eaa4f73)

  ![image](https://github.com/user-attachments/assets/18ec3c42-7eab-4602-b9a8-03c1295d03de)

## Anatomy
The <androidx.cardview.widget.CardView> is a component provided by the AndroidX library that serves as a container with a shadow and corner radius, commonly used to give a "card-like" appearance to content.
```xml
<androidx.cardview.widget.CardView
```
This takes up 80% percent of the width of the device.
```xml
app:layout_constraintWidth_percent="0.8"
```
This elvates the card.
```xml
app:cardElevation="8dp"
```
We can set <b>aspect ratio</b> as well i.e. the ratio of width and height.
```xml
app:layout_constraintDimensionRatio="2:1"
```
