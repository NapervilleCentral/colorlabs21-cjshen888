------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Collage Project
PURPOSE OF PROJECT:
VERSION or DATE:
HOW TO START THIS PROJECT:
AUTHORS:
USER INSTRUCTIONS:

How the picture was manipulated:
My picture of a chicken was manipulated in five different ways. First, edge detection was used to draw the edges in white with a black background. This was done by detecting whether the difference between two pixels was smaller than a certain amount. If it was, then it would be set to black, and vice versa. Next, a sepia tint was applied by first changing the picture into grayscale, then altering the rgb values by adding more to red and less to blue in order to make the pixels more brown tinted. Another manipulation was mirroring the image across the y-axis. This was done by reflecting the pixels across a point in the middle of the image. Furthermore, I also used recursion to manipulate the image by printing smaller and smaller versions of the image on top of the original in the center. This was done by repeatedly calling the function that copies the image with an increasing scale of decrease. Lastly, I inverted the colors by subtracting the original rgb from the max rgb value of 255 and then applied these affects in alternating stripes upon the original image.