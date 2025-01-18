# SwipeStack

This repository contains the concepts I have learnt about mobile application development over the years. And the name of the repo is inspired from the layered nature of development.

So, when we look at our mobile screen ever wondered how they come to be? How are they generated? 
First system Measures each viewgroup (say a textbox) specified dimensions, padding etc. Once that is done system moves onto Layout phase. In this phase system determines position of each views in the parent container. This involves calculating co-ordinates, layout rules defined by the parent container (relative positioning, constraints etc). Then in the draw phase system renders the view leveraging the information that it gathered in the "Measure", "Layout" phase.

<div style="margin-left: 20px;">
  <img src="https://github.com/user-attachments/assets/df3897c7-e554-4949-8a18-9d59dfe5a40e" alt="Measure Layout Draw" />
</div>

Now, there comes an issue. Some layouts like linear, relative layouts utilize nesting of viewgroups. And this makes the whole process slow. Why?  
As mentioned in the "Layout" phase system calculates stuffs like co-ordinates, layout rules etc. If there's too many nesting of groups then the system has to do more of these calculation and it'll in turn make it's moving to "Draw" phase late right? And we do not want that to happen. To get around this problem what constraint layout does is promote FlatView hierarchy. With this it can achieve intricate arrangements without relying on nested layouts. This reduces number of Measures and Layout phases needed to perform.
