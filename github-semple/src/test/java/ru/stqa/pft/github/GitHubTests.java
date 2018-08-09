package ru.stqa.pft.github;

import com.google.common.collect.ImmutableBiMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GitHubTests {

    @Test
    public void testCommit() throws IOException {
        Github github = new RtGithub("c461386f7ca5c16f2c173ab3eb9bfb756dddd376");
        RepoCommits commits = github.repos().get(
                new Coordinates.Simple("KarLLooN", "lera")).commits();
        for (RepoCommit commit : commits.iterate(
                new ImmutableBiMap.Builder<String, String>().build())){
            System.out.println(new RepoCommit.Smart(commit).message());
        }
    }
}


