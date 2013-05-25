package com.flyingh.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ValidateCodeServlet")
public class ValidateCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String STRS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final int VALIDATION_CODE_LENGTH = 4;
	private static final int LINE_NUMBER = 5;
	private static final int WIDTH = 150;
	private static final int HEIGHT = 45;
	private static Random rnd = new Random();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache"); 
		response.setDateHeader("Expires", 0);
		String validationCode = getValidationCode();
		request.getSession().setAttribute("validationCode", validationCode);
		ImageIO.write(getImage(validationCode), "jpg",
				response.getOutputStream());
	}

	private RenderedImage getImage(String validationCode) {
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		drawBackground(g);
		drawBorder(g);
		drawLine(g);
		drawString(g, validationCode);
		return image;
	}

	private void drawString(Graphics g, String validationCode) {
		for (int i = 0; i < validationCode.length(); i++) {
			g.setColor(getRandomColor());
			g.setFont(new Font("Consolas", Font.BOLD + Font.ITALIC, 20));
			Graphics2D graphics2d = (Graphics2D) g;
			int x = i * WIDTH / VALIDATION_CODE_LENGTH;
			int y = getRandomVerticalPosition();
			double theta = getTheta();
			graphics2d.rotate(theta, x, y);
			graphics2d.drawString(String.valueOf(validationCode.charAt(i)), x,
					y);
			graphics2d.rotate(-theta, x, y);
		}
	}

	private double getTheta() {
		return rnd.nextInt() % Math.PI / 6;
	}

	private int getRandomVerticalPosition() {
		if (rnd.nextInt(2) % 2 == 0) {
			return HEIGHT / 2 + rnd.nextInt(HEIGHT / 4);
		} else {
			return HEIGHT / 2 - rnd.nextInt(HEIGHT / 4);
		}
	}

	private void drawLine(Graphics g) {
		for (int i = 0; i < LINE_NUMBER; i++) {
			g.setColor(getRandomColor());
			g.drawLine(getRandom(WIDTH), getRandom(HEIGHT), getRandom(WIDTH),
					getRandom(HEIGHT));
		}
	}

	private int getRandom(int n) {
		return rnd.nextInt(n);
	}

	private void drawBorder(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(0, 0, WIDTH - 1, HEIGHT - 1);
	}

	private void drawBackground(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
	}

	private Color getRandomColor() {
		return new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));
	}

	private static String getValidationCode() {
		StringBuilder sb = new StringBuilder();
		int len = STRS.length();
		for (int i = 0; i < VALIDATION_CODE_LENGTH; i++) {
			sb.append(STRS.charAt(rnd.nextInt(len)));
		}
		return sb.toString();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
