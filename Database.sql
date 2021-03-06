USE [TestLogixTechnogoly]
GO
/****** Object:  Table [dbo].[heart]    Script Date: 2021-12-07 7:12:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[heart](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[post_id] [bigint] NOT NULL,
	[user_id] [bigint] NOT NULL,
	[heart] [int] NULL,
 CONSTRAINT [PK_heart] PRIMARY KEY CLUSTERED 
(
	[id] ASC,
	[post_id] ASC,
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[post]    Script Date: 2021-12-07 7:12:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[post](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[title] [varchar](250) NULL,
	[concept] [varchar](max) NULL,
	[create_date] [date] NULL,
 CONSTRAINT [PK_post] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[user]    Script Date: 2021-12-07 7:12:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[user](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[email] [varchar](50) NULL,
	[password] [nvarchar](max) NULL,
 CONSTRAINT [PK_user] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[heart] ON 

INSERT [dbo].[heart] ([id], [post_id], [user_id], [heart]) VALUES (1, 1, 1, 2)
INSERT [dbo].[heart] ([id], [post_id], [user_id], [heart]) VALUES (2, 1, 2, 3)
INSERT [dbo].[heart] ([id], [post_id], [user_id], [heart]) VALUES (3, 2, 1, 1)
INSERT [dbo].[heart] ([id], [post_id], [user_id], [heart]) VALUES (64, 6, 2, 3)
INSERT [dbo].[heart] ([id], [post_id], [user_id], [heart]) VALUES (65, 7, 2, 3)
INSERT [dbo].[heart] ([id], [post_id], [user_id], [heart]) VALUES (66, 8, 2, 3)
INSERT [dbo].[heart] ([id], [post_id], [user_id], [heart]) VALUES (74, 12, 2, 3)
INSERT [dbo].[heart] ([id], [post_id], [user_id], [heart]) VALUES (75, 11, 2, 3)
INSERT [dbo].[heart] ([id], [post_id], [user_id], [heart]) VALUES (76, 6, 1, 3)
INSERT [dbo].[heart] ([id], [post_id], [user_id], [heart]) VALUES (77, 8, 1, 3)
INSERT [dbo].[heart] ([id], [post_id], [user_id], [heart]) VALUES (78, 10, 1, 2)
INSERT [dbo].[heart] ([id], [post_id], [user_id], [heart]) VALUES (79, 12, 1, 1)
INSERT [dbo].[heart] ([id], [post_id], [user_id], [heart]) VALUES (80, 15, 1, 1)
INSERT [dbo].[heart] ([id], [post_id], [user_id], [heart]) VALUES (81, 6, 5, 3)
INSERT [dbo].[heart] ([id], [post_id], [user_id], [heart]) VALUES (82, 10, 5, 2)
INSERT [dbo].[heart] ([id], [post_id], [user_id], [heart]) VALUES (83, 14, 5, 1)
INSERT [dbo].[heart] ([id], [post_id], [user_id], [heart]) VALUES (84, 18, 5, 1)
INSERT [dbo].[heart] ([id], [post_id], [user_id], [heart]) VALUES (85, 5, 5, 2)
SET IDENTITY_INSERT [dbo].[heart] OFF
SET IDENTITY_INSERT [dbo].[post] ON 

INSERT [dbo].[post] ([id], [title], [concept], [create_date]) VALUES (1, N'java spring', N'awesome java spring boot 5.0', CAST(N'2021-12-02' AS Date))
INSERT [dbo].[post] ([id], [title], [concept], [create_date]) VALUES (2, N'python django', N'awesome django', CAST(N'2021-01-02' AS Date))
INSERT [dbo].[post] ([id], [title], [concept], [create_date]) VALUES (3, N'spring', N'awesome', CAST(N'2021-01-02' AS Date))
INSERT [dbo].[post] ([id], [title], [concept], [create_date]) VALUES (4, N'c++', N'great', CAST(N'2021-01-02' AS Date))
INSERT [dbo].[post] ([id], [title], [concept], [create_date]) VALUES (5, N'c', N'good', CAST(N'2021-01-01' AS Date))
INSERT [dbo].[post] ([id], [title], [concept], [create_date]) VALUES (6, N'java core', N'awesome', CAST(N'2021-12-07' AS Date))
INSERT [dbo].[post] ([id], [title], [concept], [create_date]) VALUES (7, N'c#', N'good', CAST(N'2021-12-07' AS Date))
INSERT [dbo].[post] ([id], [title], [concept], [create_date]) VALUES (8, N'java spring 1', N'good', CAST(N'2021-12-02' AS Date))
INSERT [dbo].[post] ([id], [title], [concept], [create_date]) VALUES (9, N'java 1', N'java the best 1', CAST(N'2021-12-02' AS Date))
INSERT [dbo].[post] ([id], [title], [concept], [create_date]) VALUES (10, N'java 2', N'java the best 2', CAST(N'2021-12-02' AS Date))
INSERT [dbo].[post] ([id], [title], [concept], [create_date]) VALUES (11, N'java 3', N'java the best 3', CAST(N'2021-12-02' AS Date))
INSERT [dbo].[post] ([id], [title], [concept], [create_date]) VALUES (12, N'java 4', N'java the best 4', CAST(N'2021-12-02' AS Date))
INSERT [dbo].[post] ([id], [title], [concept], [create_date]) VALUES (13, N'java 5', N'java the best 5', CAST(N'2021-12-02' AS Date))
INSERT [dbo].[post] ([id], [title], [concept], [create_date]) VALUES (14, N'java 6', N'java the best 6', CAST(N'2021-12-02' AS Date))
INSERT [dbo].[post] ([id], [title], [concept], [create_date]) VALUES (15, N'java 7', N'java the best 7', CAST(N'2021-12-02' AS Date))
INSERT [dbo].[post] ([id], [title], [concept], [create_date]) VALUES (16, N'java 8', N'java the best 8', CAST(N'2021-12-02' AS Date))
INSERT [dbo].[post] ([id], [title], [concept], [create_date]) VALUES (17, N'java 9', N'java the best 9', CAST(N'2021-12-02' AS Date))
INSERT [dbo].[post] ([id], [title], [concept], [create_date]) VALUES (18, N'java 10', N'java the best 10', CAST(N'2021-12-02' AS Date))
SET IDENTITY_INSERT [dbo].[post] OFF
SET IDENTITY_INSERT [dbo].[user] ON 

INSERT [dbo].[user] ([id], [email], [password]) VALUES (1, N'user01@gmail.com', N'123456')
INSERT [dbo].[user] ([id], [email], [password]) VALUES (2, N'user02@gmail.com', N'123456')
INSERT [dbo].[user] ([id], [email], [password]) VALUES (3, N'user03@gmail.com', N'123456')
INSERT [dbo].[user] ([id], [email], [password]) VALUES (4, N'user04@gmail.com', N'123456')
INSERT [dbo].[user] ([id], [email], [password]) VALUES (5, N'user10@gmail.com', N'123456')
SET IDENTITY_INSERT [dbo].[user] OFF
